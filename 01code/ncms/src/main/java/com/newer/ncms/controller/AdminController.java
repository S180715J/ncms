package com.newer.ncms.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newer.ncms.model.Page;
import com.newer.ncms.pojo.Dict;
import com.newer.ncms.pojo.Role;
import com.newer.ncms.pojo.User;
import com.newer.ncms.service.AdminService;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;

	/**
	 * 返回所有教师信息
	 * 
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/teacher", method = RequestMethod.GET)
	public ResponseEntity<?> teacher(@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "limit", required = false, defaultValue = "3") Integer limit) {
		Page<User> data = adminService.teacher(page, limit);
		ResponseEntity<?> entity = null;
		if (data != null) {
			entity = new ResponseEntity<>(data, HttpStatus.OK);
		}
		return entity;
	}


	
	
	/**
	 * 添加教师
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/addTeacher", method = RequestMethod.POST)
	public String addTescher(User user) {
		System.out.println("add======"+user);
		user.setCrtime(new Date());
		int i = adminService.addTescher(user);
		//Integer c = adminService.addClazz(classid, userid);
		if (i > 0 ) {
			return "ok";

		}
		return null;
	}
	
	/**
	 * 部门下拉框
	 * 
	 * @return
	 */
	@RequestMapping(value = "/dept", method = RequestMethod.GET)
	public ResponseEntity<?> dept() {
		List<Dict> dept = adminService.schoolareas();
		return new ResponseEntity<>(dept, HttpStatus.OK);
	}
	
	/**
	 * 职称下拉框
	 * @return
	 */
	@RequestMapping(value = "/role", method = RequestMethod.GET)
	public ResponseEntity<?> role() {
		List<Role> role = adminService.queryRole();
		System.out.println(role);
		return new ResponseEntity<>(role, HttpStatus.OK);
		
	}
}