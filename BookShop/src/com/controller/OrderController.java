package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bean.Cart;
import com.bean.Order;
import com.bean.User;
import com.service.OrderService;

@Controller
@RequestMapping("/user")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	
	@RequestMapping("creatOrder")
	public String CreatOrder(HttpSession session,Model model) {
		
		User user=(User)session.getAttribute("user");
		Integer user_id=user.getId();
		

		boolean result=orderService.addOrder(user_id,(List<Cart>)session.getAttribute("cartlist"));
		
		return "redirect:getOrder.action";
	}
	
	@RequestMapping("getOrder")
	public String getOrder(HttpSession session,Model model) {
		User user=(User)session.getAttribute("user");
		
		if(user!=null) {
			List<Order> orderlist=(List<Order>)orderService.getOrder(user);
			for(Order o:orderlist) {
				System.out.println(o.getOrder_id()+"  "+o.getOrder_state());
			}
			model.addAttribute("orderlist",orderlist);
			return "user/orderList";
		}
		
		String msg="请先登录载查看您的订单！";
		model.addAttribute("msg",msg);
		return "user/myaccount";
				
	}
	
	@RequestMapping("cancleOrder")
	public String cancleOrder(Integer order_id) {
		
		boolean result=orderService.cancleOrder(order_id);
		
		return "redirect:getOrder.action";
	}
	
	@RequestMapping("cleanOrder")
	public String cleanOrder(Model model,HttpSession session) {
		User user=(User)session.getAttribute("user");
		boolean result=orderService.cleanOrder(user);
		String msg="您没有订单了，还不赶快下单让自己精神丰富起来！";
		model.addAttribute("msg",msg);
		return "redirect:getOrder.action";
	}
}
