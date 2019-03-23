package com.newer.ncms.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newer.ncms.model.Page;
import com.newer.ncms.pojo.Role;
import com.newer.ncms.pojo.User;
import com.newer.ncms.service.SadminService;
/**
 * 超级管理员模块控制层
 * @author ZhangXin
 *
 */
@RestController
public class SadminController {
	Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "sadminService")
	private SadminService sadminService;

	/**
	 * .返回所有角色信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/roleList", method = RequestMethod.GET)
	public ResponseEntity<?> queryRole() {
		log.info("开始检索所有管理员信息......");
		List<Role> role = sadminService.queryRole();
		if (role == null || role.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(role, HttpStatus.OK);
		}
	}

	/**
	 * .返回所有管理员信息
	 * 
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/userlist", method = RequestMethod.GET)
	public ResponseEntity<?> queryAdmin(@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "limit", required = false, defaultValue = "3") Integer limit) {
		Page<User> data = sadminService.queryAdmin(page, limit);
		ResponseEntity<?> entity = null;
		if (data != null) {
			entity = new ResponseEntity<>(data, HttpStatus.OK);
		}
		return entity;
	}

	/**
	 * .角色身份下拉框
	 * 
	 * @return
	 */
	@RequestMapping(value = "/identity", method = RequestMethod.GET)
	public ResponseEntity<?> queryIdentity() {
		List<Role> role = sadminService.queryIdentity();
		return new ResponseEntity<>(role, HttpStatus.OK);
	}
	
	

}
