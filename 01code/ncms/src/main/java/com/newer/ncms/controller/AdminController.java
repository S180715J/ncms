package com.newer.ncms.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.newer.ncms.model.Page;
import com.newer.ncms.pojo.User;
import com.newer.ncms.service.AdminService;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	/**
	 * 返回所有教师信息
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping(value="/teacher",method=RequestMethod.GET)
	public ResponseEntity<?> teacher(@RequestParam(value="page",required=false,defaultValue="1")String page,
			@RequestParam(value="limit",required=false,defaultValue="3")Integer limit){
		Page<User> data = adminService.teacher(page, limit);
		ResponseEntity<?> entity = null;
		if(data != null) {
			entity = new ResponseEntity<>(data,HttpStatus.OK);
		}
		return entity;
	}
	
	/**
	 * 添加教师
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/addTescher",method=RequestMethod.POST)
	public ResponseEntity<?> addTescher(User user){
		user.setCrtime(new Date());
		//user.setNewdate(new Date());
		Integer i = adminService.addTescher(user);
		if(i!=null) {
			return new ResponseEntity<String>("ok",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("fail",HttpStatus.EXPECTATION_FAILED);
		}
		
	}
}