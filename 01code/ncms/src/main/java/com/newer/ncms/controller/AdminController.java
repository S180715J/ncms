package com.newer.ncms.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
		return new ResponseEntity<>(role, HttpStatus.OK);
		
	}
	
	/**
	 * 删除教师
	 * @param userid
	 * @return
	 */
	@RequestMapping(value = "/delTeacher", method = RequestMethod.DELETE)
	public String delTeacher(String userid) {
		String id[] = userid.split(",");
		int[] arr = new int[id.length];
		for (int i = 0; i < id.length; i++) {
			arr[i] = Integer.parseInt(id[i]);
			int delStudent = adminService.delTeacher(arr[i]);
			if (delStudent <= 0) {
				return "fail";
			}
		}

		return "ok";

	}
	
	/**
	 * 修改教师
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/upTeacher", method = RequestMethod.PUT)
	public String upTeacher(User user) {
		int updStudent = adminService.upTeacher(user);
		if (updStudent > 0) {
			return "ok";
		} else {
			return "fail";
		}
	}
	
	/**
	 * 修改教师回显数据
	 * @param userid
	 * @return
	 */
	@RequestMapping(value = "/showTeacher/{userid}", method = RequestMethod.GET)
	public ResponseEntity<?> showTeacher(@PathVariable("userid")Integer userid) {
		User showTeacher = adminService.showTeacher(userid);
		if (showTeacher != null) {
			return new ResponseEntity<>(showTeacher, HttpStatus.OK);
		}
		return null;

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
		if (i > 0 ) {
			return "ok";

		}
		return null;
	}
	
	
	/**
	 * 删除班级
	 * @param userid
	 * @return
	 */
	@RequestMapping(value = "/delClass", method = RequestMethod.DELETE)
	public String delClass(String classid) {
		String id[] = classid.split(",");
		int[] arr = new int[id.length];
		for (int i = 0; i < id.length; i++) {
			arr[i] = Integer.parseInt(id[i]);
			int delCLass = adminService.delClass(arr[i]);
			if (delCLass <= 0) {
				return "fail";
			}
		}

		return "ok";

	}
	
	
	/**
	 * 修改班级
	 * @param clazz
	 * @return
	 */
	@RequestMapping(value = "/upClass", method = RequestMethod.PUT)
	public String upClass(Clazz clazz) {
		int updStudent = adminService.upClass(clazz);
		System.out.println(clazz);
		if (updStudent > 0) {
			return "ok";
		} else {
			return "fail";
		}
	}
	
	/**
	 * 修改班级回显数据
	 * @param classid
	 * @return
	 */
	@RequestMapping(value = "/showClass/{classid}", method = RequestMethod.GET)
	public ResponseEntity<?> showClass(@PathVariable("classid")Integer classid) {
		Clazz showClass = adminService.showClass(classid);
		if (showClass != null) {
			return new ResponseEntity<>(showClass, HttpStatus.OK);
		}
		return null;

	}
}