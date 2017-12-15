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
		//取一下用户
		User user=(User)session.getAttribute("user");
		//如果用户没登录则登录
		if(user==null) {
			String msg="请先登录在添加购物车";
			System.out.println(msg);
			model.addAttribute("msg",msg);
			return "user/myaccount";
		}else {
			//验证是否方法执行和参数的值是什么
			String username=user.getUsername();
			System.out.println(username+"要买的书："+book_id);
			//取一下用户的id
			Integer user_id=user.getId();
			System.out.println(user_id);
			cartService.addCart(book_id,user_id,book_name,price);
			//调用一下查看购物车的方法，将添加的书品展示出来
			myCart(model,session);
			return "user/cartList";
		}
	}
	@RequestMapping("getMyCart")
	public String myCart(Model model, HttpSession session) {
		//取一下用户的姓名
		User user=(User)session.getAttribute("user");
		if(user!=null) {
			Integer user_id=user.getId();
			String username=user.getUsername();
			//将购物车表中的结果放入list中
			List<Cart> cartlist=new ArrayList<Cart>();
			cartlist=cartService.getMyCart(user_id);
			session.setAttribute("cartlist",cartlist);
			model.addAttribute("cartlist",cartlist);
			model.addAttribute("username",username);
			
			return "user/cartList";
		}
		String msg = "请先登录，在查看您的购物车！";
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
		
		System.out.println("这个user_id="+user_id+"开始清空我的购物车了");
		boolean result = cartService.cleanCart(user_id);
		
		String msg="你的购物车已经清空！";
		model.addAttribute("msg",msg);
		
		return "redirect:getMyCart.action";

	}
	
}
