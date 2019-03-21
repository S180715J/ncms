package com.newer.ncms.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.newer.ncms.model.Page;
import com.newer.ncms.pojo.Clazz;
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
		user.setCrtime(new Date());
		int i = adminService.addTeacher(user);
		System.out.println(user);
		if (i > 0 ) {
			return "ok";

		}
		return null;
	}
	

	
	/**
	 * 显示所属校区、专业方向、班级状态下拉框
	 * @return
	 */
	@RequestMapping(value = "/merge", method = RequestMethod.GET)
	public ResponseEntity<?> data() {
		List<Dict> schoolareas = adminService.schoolareas();
		List<Dict> specialtys = adminService.specialty();
		List<Dict> classStatus = adminService.classStatus();
		List<List<?>> list = new ArrayList<>();
		list.add(schoolareas);
		list.add(specialtys);
		list.add(classStatus);
		return new ResponseEntity<>(list, HttpStatus.OK);
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
	
	/**
	 * 删除教师
	 * @param userid
	 * @return
	 */
	@DeleteMapping("/deleteTeacher/{userid}")
	public  ResponseEntity<?> deleteTeacher(@PathVariable("userid") Integer userid){
		if(userid == null) {
			return new ResponseEntity<>("NOT FOUND:"+userid,HttpStatus.NO_CONTENT);
		}else {
			Integer i = adminService.deleteTeacher(userid);
			return new ResponseEntity<String>(i>0?"ok":"nodata",HttpStatus.OK);
		}
	}
	
	/**
	 * 返回班级信息
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/clazz", method = RequestMethod.GET)
	public ResponseEntity<?> clazz(@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "limit", required = false, defaultValue = "3") Integer limit) {
		Page<Clazz> data = adminService.clazz(page, limit);
		ResponseEntity<?> entity = null;
		if (data != null) {
			entity = new ResponseEntity<>(data, HttpStatus.OK);
		}
		return entity;
	}
	
	/**
	 * 添加班级
	 * @param clazz
	 * @return
	 */
	@RequestMapping(value = "/addClass", method = RequestMethod.POST)
	public String addClass(Clazz clazz) {
		int i = adminService.addClass(clazz);
		System.out.println(clazz);
		if (i > 0 ) {
			return "ok";

		}
		return null;
	}
}