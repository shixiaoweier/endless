package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.Admin;
import com.service.AdminService;

@Controller
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("login")
	public String login(@RequestParam String admin_name,@RequestParam String admin_password,Model model) {
		Admin admin=adminService.login(admin_name,admin_password);
		if(admin!=null) {
			return "admin/admin_main";
		}
		return "admin/admin_login?alert(‘管理名和密码不正确！’)";
	}

	
}
