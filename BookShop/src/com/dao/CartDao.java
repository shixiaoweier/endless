package com.dao;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Cart;
import com.bean.User;

@Repository
public class CartDao {

	@Autowired
	private SessionFactory sessionFactory;

	//���û����ӹ��򱣴���Ӽ�¼�������ӹ���ֱ�Ӹ���number
	public boolean addCart(Integer book_id, Integer user_id,String book_name,double price) {
		Session session= sessionFactory.openSession();
		Transaction tran=session.beginTransaction();
		
		//�������趨
		//�Ȳ鿴��ǰ�û���û������Ȿ��
		Query query=session.createQuery("from Cart c where user_id=? and book_id=?");
		query.setParameter(0, user_id);
		query.setParameter(1, book_id);
		Cart c=(Cart)query.uniqueResult();
		
		//�û��Ѿ����Ȿ����빺�ﳵ,���޸��鱾������
		if(c!=null){
			Query query1=session.createQuery("update Cart set NUMBER=? where USER_ID=? and BOOK_ID=?");
			query1.setParameter(0, c.getNumber()+1);
			query1.setParameter(1, user_id);
			query1.setParameter(2, book_id);
			int result=query1.executeUpdate();
			tran.commit();	
		}

		//�û�û�н��Ȿ����빺�ﳵ,���ڹ��ﳵ�ı��в���һ����¼
		else {
			Integer number=0;
			System.out.println(number);
			Cart cart=new Cart();

			cart.setUser_id(user_id);
			cart.setBook_id(book_id);
			cart.setBook_name(book_name);
			cart.setNumber(1);
			cart.setPrice(price);
			
			session.save(cart);
			tran.commit();
		}
		return true;
	}
	
	public List<Cart> getMyCart(Integer user_id) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Cart where USER_ID=?");
		query.setParameter(0, user_id);
		List<Cart> cartlist=query.list();
		return cartlist;
	}

	//�����ɶ���֮���ﳵҪ���
	public boolean cleanCart(Integer user_id) {
	
		Session session=sessionFactory.getCurrentSession();		
		
		Query query=session.createQuery("delete from Cart where user_id=?");
		query.setParameter(0, user_id);
		int result = query.executeUpdate();
		
		System.out.println("ɾ�����ﳵ�ɹ�");
		return false;
	
	}

	public boolean deleteCartBook(Integer book_id) {
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("delete from Cart where book_id=?");
		query.setParameter(0, book_id);
		int result=query.executeUpdate();
		
		System.out.println("ɾ��ĳһ����Ʒ�ɹ�");
		return false;
	}

}



