package com.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bean.Book;
import com.bean.User;
import com.service.BookService;
import com.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private BookService bookService;
	
	//ע�᷽����ע��ʱ�ϴ�ͷ����д�����ݿ�
	@RequestMapping("/register")
	public String register(User user,String username,HttpServletRequest request,Model model,@RequestParam MultipartFile img) throws IOException, AddressException, MessagingException {
		//�ļ��ϴ�
		ServletContext servletContext=request.getServletContext();
		String realpath=servletContext.getRealPath("/uploadimgs");
		request.getServletContext();
		//�ж���Ŀ���Ƿ���uploadimgs�ļ��У����û���򴴽���
		File file1=new File(realpath);
		if(!file1.exists()) {
			file1.mkdir();
		}
		if(img!=null) {
			//�������Ե�ַ����model�з���չʾ�û���Ϣ
			String originalPath=realpath+"/"+img.getOriginalFilename();
			model.addAttribute("realpath",realpath);
			//�����ļ��ľ���·������д��ͼƬ��Ϣ
			File file2=new File(originalPath);
			FileOutputStream fos=new FileOutputStream(file2);
			fos.write(img.getBytes());
			fos.flush();
			fos.close();
			user.setImgurl(realpath+img.getOriginalFilename());
		}
		//�������伤���,���user����model
		EnableEmail(user);
		//���ݿ�������,����user����model���Է��㿴ע����Ϣ��
		model.addAttribute(user);
		System.out.println(user.getUsername()+"  Usercontroller");
		boolean result=userService.addUser(user);
		if(result) {
			return "user/ShowRegisterInfo";
		}
		return "user/register";
	}
	
	//��������ķ�������ע�᷽���н��е��á�
	public void EnableEmail(User user) throws AddressException, MessagingException {
		Properties props=new Properties();
		props.put("mail.smtp.host", "smtp.163.com");
		//�����ʼ�Э������
		props.put("mail.transport.protocol", "stmp");
		// �Ƿ���֤  
		props.put("mail.smtp.auth", true);
		//����java��������ʼ��������ĻỰʵ��
		Session mailSession = Session.getInstance(props,new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("javamail5678@163.com","javamail5678sqm");
			}
		});
		Message msg = new MimeMessage(mailSession);//ʵ��������
		//�����ʼ��ķ�����
		msg.setFrom(new InternetAddress("javamail5678@163.com"));
		//�����ռ���
		msg.addRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
		//�ʼ�������
		msg.setSubject("��������");
		//����ʱ��
		msg.setSentDate(new Date());
		//�ʼ�����
		 MimeBodyPart mbp=new MimeBodyPart();
		 mbp.setContent("����һ������<a href='http://localhost:8080/BookShop/user/jihuoSuccess.jsp'> ����  </a>","text/html;charset=UTF-8");
		MimeMultipart mm=new MimeMultipart();
		mm.addBodyPart(mbp);
		msg.setContent(mm);
		Transport.send(msg);
				
	}

	//�û���¼ʱ��֤�Ƿ��Ѿ�ע��
	@RequestMapping("/login")
	public String login(@RequestParam String username,
					    @RequestParam String password,
					    HttpSession session,
					    Model model) {
		System.out.println(username+"    loginUserController");
		User user=userService.SelectUser(username);
		List<Book> booklist=bookService.getAllBook();
		model.addAttribute("booklist",booklist);
		if(user!=null) {
			session.setAttribute("user",user);
			return "user/bookList";
		}
		
		String message="����ע���ٵ�¼��";
		model.addAttribute("message",message);
		return "user/register";
	}
	
	//�һ�����ķ���
	@RequestMapping("/findPassword")
	public String findpassword(@RequestParam String username,
			   					@RequestParam String email,
			   					Model model) throws AddressException, MessagingException{
		//���û��б����ҵ��û�������Ӧ������
		User user=userService.SelectUser(username);
		if(user.getUsername().equals(username)) {
				String p=user.getPassword();
				String name=user.getUsername();
				model.addAttribute("p",p);
				model.addAttribute("name",name);
		}
			System.out.println("findpassword  UserController");
		//���÷����һ������ʼ��ķ���
		FindPasswordEmail(email);	
		return "user/findPasswordSuccess";
	}
	//�����һ������ʼ��ķ���,���һ����뷽���н��е���
	public static void FindPasswordEmail(@RequestParam String email) throws AddressException, MessagingException {
		Properties props=new Properties();
		props.put("mail.smtp.host", "smtp.163.com");
		//�����ʼ�Э������
		props.put("mail.transport.protocol", "stmp");
		// �Ƿ���֤  
		props.put("mail.smtp.auth", true);
		//����java��������ʼ��������ĻỰʵ��
		Session mailSession = Session.getInstance(props,new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("javamail5678@163.com","javamail5678sqm");
			}
		});
		Message msg = new MimeMessage(mailSession);//ʵ��������
		//�����ʼ��ķ�����
		msg.setFrom(new InternetAddress("javamail5678@163.com"));
		//�����ռ���
		msg.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
		//�ʼ�������
		msg.setSubject("�һ�����");
		//����ʱ��
		msg.setSentDate(new Date());
		//�ʼ�����
		 MimeBodyPart mbp=new MimeBodyPart();
		 mbp.setContent("����һ������<a href='http://localhost:8080/BookShop/user/findPasswordSuccess.jsp'> �һ�����  </a>","text/html;charset=UTF-8");
		MimeMultipart mm=new MimeMultipart();
		mm.addBodyPart(mbp);
		msg.setContent(mm);
		Transport.send(msg);
		
		
	}
}
