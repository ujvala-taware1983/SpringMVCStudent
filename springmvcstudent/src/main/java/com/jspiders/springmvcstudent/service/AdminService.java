package com.jspiders.springmvcstudent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springmvcstudent.pojo.AdminPOJO;
import com.jspiders.springmvcstudent.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository repository;

	public AdminPOJO addAdmin(String username, String password) {
		AdminPOJO admin = repository.addAdmin(username, password);
		return admin;
	}

	public AdminPOJO login(String username, String password) {
		AdminPOJO admin = repository.login(username, password);
		return admin;
	}

}
