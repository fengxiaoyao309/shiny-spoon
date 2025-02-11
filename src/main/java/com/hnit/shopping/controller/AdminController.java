package com.hnit.shopping.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hnit.shopping.entity.Admin;
import com.hnit.shopping.service.IAdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private IAdminService adminService;
	
	//localhost:8080/shopping/admin/login?aName=lili&aPwd=123
	@GetMapping("/login")
	public Admin login(Admin admin) {
		admin.setaRole("超级管理员");
		
		return admin;
	}

}
