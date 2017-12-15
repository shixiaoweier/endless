package com.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Cart;
import com.bean.Order;
import com.bean.OrderDetail;
import com.bean.User;

@Repository
public class OrderDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private CartDao cartDao;
	
	public boolean addOrder(Integer user_id,List<Cart> cartlist) {
		Session session=sessionFactory.getCurrentSession();
		
		Order order=new Order();
		//����ǰ�û���һ����¼��ѯ����
		System.out.println(user_id);
		User user=session.get(User.class, user_id);		
		order.setOrder_state("δ����");
		Set<Order> orderSet = user.getOrderSet();
		
		orderSet.add(order);
		order.setUser(user);
		
		for(int i=0;i<cartlist.size();i++) {
			OrderDetail orderDetail = new OrderDetail();
			
			orderDetail.setBook_id(cartlist.get(i).getBook_id());
			orderDetail.setNumber(cartlist.get(i).getNumber());
			orderDetail.setPrice(cartlist.get(i).getPrice());
			
			Set<OrderDetail> orderDetailSet = order.getOrderDetailSet();
			orderDetailSet.add(orderDetail);
			orderDetail.setOrder(order);
		}
		
		session.update(user);
		//���ɶ���֮��Ҫ�ѹ��ﳵ��ļ�¼���
		cartDao.cleanCart(user_id);
		return false;
	}

	public List<Order> getOrder(User user) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("�鿴�����б�");
		Query query=session.createQuery("from Order where user=?");
		query.setParameter(0, user);
		List<Order> orderlist=query.list();
		return orderlist;
	}

	public Order getOrderById(Integer order_id) {
		Session session=sessionFactory.getCurrentSession();
		Order order=session.get(Order.class, order_id);
		return order;
	}

	public boolean cancleOrder(Integer order_id) {
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("delete from Order where order_id=?");
		query.setParameter(0, order_id);
		int result=query.executeUpdate();
		
		return false;
	}

	public boolean cleanOrder(User user) {
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("delete from Order where user=?");
		query.setParameter(0, user);
		int result = query.executeUpdate();
		
		return false;
	}

}
