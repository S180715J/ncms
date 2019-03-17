package com.newer.ncms.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newer.ncms.mapper.LoginMapper;
import com.newer.ncms.pojo.User;

/**
 * 登录业务逻辑层
 * @author ZhangXin
 *
 */
@Service
public class LoginService {
	@Autowired
	private LoginMapper loginMapper;
	
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	public User login(User user) {
		return loginMapper.login(user);
	}
	

}
