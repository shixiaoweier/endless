package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bean.Cart;
import com.bean.User;
import com.service.CartService;

@Controller
@RequestMapping("/user")
public class CartController {
	@Autowired
	private CartService cartService;
	@RequestMapping("addCart")
	public String addCart(Integer book_id,
						  String book_name,
						  double price,
			              HttpSession session,
			              Model model,
			              HttpServletRequest request,
			              HttpServletResponse response
			              )  {
		//ȡһ���û�
		User user=(User)session.getAttribute("user");
		//����û�û��¼���¼
		if(user==null) {
			String msg="���ȵ�¼����ӹ��ﳵ";
			System.out.println(msg);
			model.addAttribute("msg",msg);
			return "user/myaccount";
		}else {
			//��֤�Ƿ񷽷�ִ�кͲ�����ֵ��ʲô
			String username=user.getUsername();
			System.out.println(username+"Ҫ����飺"+book_id);
			//ȡһ���û���id
			Integer user_id=user.getId();
			System.out.println(user_id);
			cartService.addCart(book_id,user_id,book_name,price);
			//����һ�²鿴���ﳵ�ķ���������ӵ���Ʒչʾ����
			myCart(model,session);
			return "user/cartList";
		}
	}
	@RequestMapping("getMyCart")
	public String myCart(Model model, HttpSession session) {
		//ȡһ���û�������
		User user=(User)session.getAttribute("user");
		if(user!=null) {
			Integer user_id=user.getId();
			String username=user.getUsername();
			//�����ﳵ���еĽ������list��
			List<Cart> cartlist=new ArrayList<Cart>();
			cartlist=cartService.getMyCart(user_id);
			session.setAttribute("cartlist",cartlist);
			model.addAttribute("cartlist",cartlist);
			model.addAttribute("username",username);
			
			return "user/cartList";
		}
		String msg = "���ȵ�¼���ڲ鿴���Ĺ��ﳵ��";
		model.addAttribute("msg",msg);
		return "user/myaccount";
		
		
	}
	
	@RequestMapping("deleteCartBook")
	public String deleteCartBook(Integer book_id) {
		boolean result = cartService.deleteCartBook(book_id);
		
		return "redirect:getMyCart.action";

	}
	
	@RequestMapping("cleanCart")
	public String cleanCart(HttpSession session,Model model) {
		
		User user=(User)session.getAttribute("user");
		Integer user_id=user.getId();
		
		System.out.println("���user_id="+user_id+"��ʼ����ҵĹ��ﳵ��");
		boolean result = cartService.cleanCart(user_id);
		
		String msg="��Ĺ��ﳵ�Ѿ���գ�";
		model.addAttribute("msg",msg);
		
		return "redirect:getMyCart.action";

	}
	
}
