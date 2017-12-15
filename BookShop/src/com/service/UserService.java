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
	//注册时添加用户
	public boolean addUser(User user) {
		//System.out.println(user.getUsername()+"  Userservice");
		return userDao.addUser(user);
	}
	//查询所有的用户
	public User SelectUser(String username){
		//System.out.println("login+UserService");
		return userDao.SelectUser(username);
	}
}
