package com.dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Admin;

@Repository
public class AdminDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public Admin login(String admin_name, String admin_password) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Admin where admin_name=? and admin_password=?");
		query.setParameter(0, admin_name);
		query.setParameter(1, admin_password);
		Admin admin=(Admin)query.uniqueResult();
		
		return admin;
	}
	

}
