package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.bean.Cart;
import com.bean.Order;
import com.bean.OrderDetail;
import com.dao.OrderDetailDao;

@Service
@Transactional
public class OrderDetailService {

	@Autowired
	private OrderDetailDao orderDetailDao;

	public List<OrderDetail> getOrderDetail(Integer order_id) {
		return orderDetailDao.getOrderDetail(order_id);
	}
	
	
}
