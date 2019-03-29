package com.newer.ncms.controller;

import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.newer.ncms.pojo.Role;
import com.newer.ncms.pojo.User;
import com.newer.ncms.service.LoginService;
import com.newer.ncms.utils.JwtTokenUtil;

/**
 * 登录控制器
 * 
 * @author ZhangXin
 *
 */
@RestController
public class LoginController {
	@Autowired
	private LoginService loginService;

	// 自动注入JWT工具类
	@Autowired
	private JwtTokenUtil JwtTokenUtil;

	@Value("${jwt.header}")
	private String tokenHeader;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(User user) {
		User user2 = loginService.login(user);
		if (user2 != null) {
			if (user.getRole().getRoleid() == user2.getRole().getRoleid()) {
				String token = JwtTokenUtil.createJwt(user2);
				return token;
			} else {
				return "fail";
			}
		}
		return "0";
	}

	/**
	 * 返回数据显示用户名
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/show", method = RequestMethod.POST)
	public ResponseEntity<?> show(HttpServletRequest req) {
		LinkedHashMap<String, Object> user = JwtTokenUtil.getObj(req);
		if (user != null) {
			User user2 = new User();
			user2.setUsername((String) user.get("username"));
			LinkedHashMap<String, Object> role1 = (LinkedHashMap<String, Object>) user.get("role");
			Role role = new Role();
			role.setRoleid((Integer) role1.get("roleid"));
			role.setRolename((String) role1.get("rolename"));
			user2.setRole(role);
			return new ResponseEntity<>(user2, HttpStatus.OK);
		}
		return null;
	}

}
