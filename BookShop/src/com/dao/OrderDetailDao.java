package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Order;
import com.bean.OrderDetail;

@Repository
public class OrderDetailDao {

	@Autowired
	private SessionFactory sessionFactory;
	public List<OrderDetail> getOrderDetail(Integer order_id) {
		Session session=sessionFactory.getCurrentSession();
		//根据order_id得到order
		Order order = (Order)session.get(Order.class, order_id);
		//List<OrderDetail> orderDetaillist=(List<OrderDetail>)session.get(OrderDetail.class,order_id);
		Query query=session.createQuery("from OrderDetail where order=?");
		query.setParameter(0, order);
		List<OrderDetail> orderDetaillist = query.list();
		return orderDetaillist;
	}
	
}
