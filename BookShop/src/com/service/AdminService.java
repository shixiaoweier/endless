package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Admin;
import com.dao.AdminDao;

@Service
@Transactional
public class AdminService {

	@Autowired
	private AdminDao adminDao;

	public Admin login(String admin_name, String admin_password) {
		return adminDao.login(admin_name,admin_password);
	}
	
}
