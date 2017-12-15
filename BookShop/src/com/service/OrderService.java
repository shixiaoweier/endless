package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Cart;
import com.bean.Order;
import com.bean.User;
import com.dao.OrderDao;

@Service
@Transactional
public class OrderService {

	@Autowired
	private OrderDao orderDao;

	public boolean addOrder(Integer user_id,List<Cart> cartlist) {
		return orderDao.addOrder(user_id,cartlist);
	}

	public List<Order> getOrder(User  user) {
		return orderDao.getOrder(user);
	}

	public Order getOrderById(Integer order_id) {
		return orderDao.getOrderById(order_id);
	}

	public boolean cancleOrder(Integer order_id) {
		return orderDao.cancleOrder(order_id);
	}

	public boolean cleanOrder(User user) {
		return orderDao.cleanOrder(user);
	}
}
