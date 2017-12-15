package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bean.OrderDetail;
import com.service.CartService;
import com.service.OrderDetailService;
import com.service.OrderService;

@Controller
@RequestMapping("user")
public class OrderDetailController {
	
	@Autowired
	private OrderDetailService orderDetailService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private OrderService orderService;
	
	
	@RequestMapping("getOrderDetail")
	public String getOrderDetail(Integer order_id,Model model,HttpSession session) {
		System.out.println(order_id);
		List<OrderDetail> orderDetailList = orderDetailService.getOrderDetail(order_id);
		double pay=0;
		for(OrderDetail orderDetail:orderDetailList) {
			double p=orderDetail.getNumber()*orderDetail.getPrice();
			pay=pay+p;
		}
		System.out.println(pay);
		model.addAttribute(orderDetailList);
		session.setAttribute("pay", pay);
		return "user/orderDetailList";

	}
	
}
