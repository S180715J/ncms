package com.newer.ncms.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newer.ncms.mapper.AdminMapper;
/**
 * 管理员模块业务逻辑层
 * @author yuanyonghong
 *
 */
import com.newer.ncms.model.Page;
import com.newer.ncms.pojo.User;
@Service
public class AdminService {
	
	@Autowired
	private AdminMapper adminMapper;
	
	/**
	 * 查询教师
	 * @param curPage
	 * @param limit
	 * @return
	 */
	 public Page<User> teacher(String curPage,Integer limit){
		  HashMap<String, Object> params = new HashMap<>();
		  
		  //获得总记录数
		  int teacherTotal = adminMapper.teacherTotal();
		  if(teacherTotal != 0) {
			//创建page对象
			 Page<User> page = new Page<>(curPage, teacherTotal,limit);
			 //获得起始索引
			 int index = (page.getCurPage() -1) * limit;
			 params.put("index", index);
			 params.put("limit", limit);
			 
			 //根据条件查询员工信息
			 List<User> tescher = adminMapper.tescher(params);
			 page.setList(tescher);
			 return page;
		  }
		  return null;
	 }

	 /**
	  * 添加教师
	  * @param user
	  * @return
	  */
	 public Integer addTescher(User user) {
		 return  adminMapper.addTescher(user);
		 
	 }
}
