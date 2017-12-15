package com.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.User;

@Repository

public class UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean addUser(User user) {

		Session session = sessionFactory.getCurrentSession();
		System.out.println(user.getUsername()+"  UserDao");
		session.save(user);
		return true;	
	}

	public User SelectUser(String username) {
		Session session=sessionFactory.getCurrentSession();
		System.out.println("login+UserDao");
		String sql=" from User u where u.username=?";
		Query query=session.createQuery(sql);
		query.setParameter(0, username);
		User user=(User)query.uniqueResult();
		return user;
	}

}
