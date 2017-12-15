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
	
	//注册方法，注册时上传头像并且写入数据库
	@RequestMapping("/register")
	public String register(User user,String username,HttpServletRequest request,Model model,@RequestParam MultipartFile img) throws IOException, AddressException, MessagingException {
		//文件上传
		ServletContext servletContext=request.getServletContext();
		String realpath=servletContext.getRealPath("/uploadimgs");
		request.getServletContext();
		//判断项目中是否有uploadimgs文件夹，如果没有则创建，
		File file1=new File(realpath);
		if(!file1.exists()) {
			file1.mkdir();
		}
		if(img!=null) {
			//并将绝对地址放在model中方便展示用户信息
			String originalPath=realpath+"/"+img.getOriginalFilename();
			model.addAttribute("realpath",realpath);
			//创建文件的绝对路径，并写入图片信息
			File file2=new File(originalPath);
			FileOutputStream fos=new FileOutputStream(file2);
			fos.write(img.getBytes());
			fos.flush();
			fos.close();
			user.setImgurl(realpath+img.getOriginalFilename());
		}
		//调用邮箱激活方法,入参user出参model
		EnableEmail(user);
		//数据库插入操作,并将user放入model中以方便看注册信息。
		model.addAttribute(user);
		System.out.println(user.getUsername()+"  Usercontroller");
		boolean result=userService.addUser(user);
		if(result) {
			return "user/ShowRegisterInfo";
		}
		return "user/register";
	}
	
	//激活邮箱的方发，在注册方法中进行调用。
	public void EnableEmail(User user) throws AddressException, MessagingException {
		Properties props=new Properties();
		props.put("mail.smtp.host", "smtp.163.com");
		//发送邮件协议名称
		props.put("mail.transport.protocol", "stmp");
		// 是否认证  
		props.put("mail.smtp.auth", true);
		//创建java程序端与邮件服务器的会话实例
		Session mailSession = Session.getInstance(props,new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("javamail5678@163.com","javamail5678sqm");
			}
		});
		Message msg = new MimeMessage(mailSession);//实例化子类
		//设置邮件的发件人
		msg.setFrom(new InternetAddress("javamail5678@163.com"));
		//设置收件人
		msg.addRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
		//邮件的主题
		msg.setSubject("激活邮箱");
		//发送时间
		msg.setSentDate(new Date());
		//邮件内容
		 MimeBodyPart mbp=new MimeBodyPart();
		 mbp.setContent("请点击一下链接<a href='http://localhost:8080/BookShop/user/jihuoSuccess.jsp'> 激活  </a>","text/html;charset=UTF-8");
		MimeMultipart mm=new MimeMultipart();
		mm.addBodyPart(mbp);
		msg.setContent(mm);
		Transport.send(msg);
				
	}

	//用户登录时验证是否已经注册
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
		
		String message="请先注册再登录！";
		model.addAttribute("message",message);
		return "user/register";
	}
	
	//找回密码的方法
	@RequestMapping("/findPassword")
	public String findpassword(@RequestParam String username,
			   					@RequestParam String email,
			   					Model model) throws AddressException, MessagingException{
		//从用户列表中找到用户名所对应的密码
		User user=userService.SelectUser(username);
		if(user.getUsername().equals(username)) {
				String p=user.getPassword();
				String name=user.getUsername();
				model.addAttribute("p",p);
				model.addAttribute("name",name);
		}
			System.out.println("findpassword  UserController");
		//调用发送找回密码邮件的方法
		FindPasswordEmail(email);	
		return "user/findPasswordSuccess";
	}
	//发送找回密码邮件的方法,在找回密码方法中进行调用
	public static void FindPasswordEmail(@RequestParam String email) throws AddressException, MessagingException {
		Properties props=new Properties();
		props.put("mail.smtp.host", "smtp.163.com");
		//发送邮件协议名称
		props.put("mail.transport.protocol", "stmp");
		// 是否认证  
		props.put("mail.smtp.auth", true);
		//创建java程序端与邮件服务器的会话实例
		Session mailSession = Session.getInstance(props,new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("javamail5678@163.com","javamail5678sqm");
			}
		});
		Message msg = new MimeMessage(mailSession);//实例化子类
		//设置邮件的发件人
		msg.setFrom(new InternetAddress("javamail5678@163.com"));
		//设置收件人
		msg.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
		//邮件的主题
		msg.setSubject("找回密码");
		//发送时间
		msg.setSentDate(new Date());
		//邮件内容
		 MimeBodyPart mbp=new MimeBodyPart();
		 mbp.setContent("请点击一下链接<a href='http://localhost:8080/BookShop/user/findPasswordSuccess.jsp'> 找回密码  </a>","text/html;charset=UTF-8");
		MimeMultipart mm=new MimeMultipart();
		mm.addBodyPart(mbp);
		msg.setContent(mm);
		Transport.send(msg);
		
		
	}
}
