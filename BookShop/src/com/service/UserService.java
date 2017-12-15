package com.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.User;
import com.dao.UserDao;

@Service
@Transactional
public class UserService {
	@Autowired
	private UserDao userDao;
	//ע��ʱ����û�
	public boolean addUser(User user) {
		//System.out.println(user.getUsername()+"  Userservice");
		return userDao.addUser(user);
	}
	//��ѯ���е��û�
	public User SelectUser(String username){
		//System.out.println("login+UserService");
		return userDao.SelectUser(username);
	}
}
