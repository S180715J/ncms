package com.newer.ncms.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newer.ncms.mapper.SadminMapper;
import com.newer.ncms.model.Page;
import com.newer.ncms.pojo.Role;
import com.newer.ncms.pojo.User;

@Service(value = "sadminService")
public class SadminService {

	@Autowired
	private SadminMapper sadminMapper;

	/**
	 * .返回所有角色信息
	 * 
	 * @return
	 */
	public List<Role> queryRole() {
		return sadminMapper.selectRole();
	}

	/**
	 * .返回所有管理员信息
	 * 
	 * @param curPage
	 * @param limit
	 * @return
	 */
	public Page<User> queryAdmin(String curPage, Integer limit) {
		HashMap<String, Object> params = new HashMap<>();
		// 获得总记录数
		int totalrows = sadminMapper.adminSum();
		if (totalrows != 0) {
			// 创建page对象
			Page<User> page = new Page<>(curPage, totalrows, limit);
			// 获得起始索引
			int index = (page.getCurPage() - 1) * limit;
			params.put("index", index);
			params.put("limit", limit);
			// 根据条件查询员工信息
			List<User> list = sadminMapper.selectAdmin(params);
			page.setList(list);
			return page;
		}
		return null;
	}

}
