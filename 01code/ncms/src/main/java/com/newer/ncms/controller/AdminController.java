package com.newer.ncms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.newer.ncms.service.AdminService;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
}