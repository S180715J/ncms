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
import com.newer.ncms.pojo.Clazz;
import com.newer.ncms.pojo.Dict;
import com.newer.ncms.pojo.Role;
import com.newer.ncms.pojo.User;

@Service
public class AdminService {

	@Autowired
	private AdminMapper adminMapper;

	/**
	 * 查询教师
	 * 
	 * @param curPage
	 * @param limit
	 * @return
	 */
	public Page<User> teacher(String curPage, Integer limit) {
		HashMap<String, Object> params = new HashMap<>();

		// 获得总记录数
		int teacherTotal = adminMapper.teacherTotal();
		if (teacherTotal != 0) {
			// 创建page对象
			Page<User> page = new Page<>(curPage, teacherTotal, limit);
			// 获得起始索引
			int index = (page.getCurPage() - 1) * limit;
			params.put("index", index);
			params.put("limit", limit);

			// 根据条件查询员工信息
			List<User> tescher = adminMapper.tescher(params);
			page.setList(tescher);
			return page;
		}
		return null;
	}
	
	/**
	 * 查询所在校区
	 * 
	 * @return List<Dict>
	 */
	public List<Dict> schoolareas() {
		return adminMapper.schoolareas();
	}
	
	/**
	 * 查询专业方向
	 * @return
	 */
	public List<Dict> specialty() {
		return adminMapper.specialty();
	}
	
	/**
	 * 查询班级状态
	 * @return
	 */
	public List<Dict> classStatus() {
		return adminMapper.classStatus();
	}
	
	/**
	 * 查询角色
	 * @return
	 */
	public List<Role> queryRole(){
		return adminMapper.queryRole();
	}

	/**
	 * 添加教师
	 * 
	 * @param user
	 * @return
	 */
	public Integer addTeacher(User user) {
		return adminMapper.addTeacher(user);

	}
	
	/**
	 * 添加班级
	 * @param classid
	 * @param userid
	 * @return
	 
	public Integer addClazz(Integer classid,Integer userid) {
		return adminMapper.addClazz(classid, userid);
	}
	*/

	/**
	 * 删除教师
	 * @param userid
	 * @return
	 */
	public Integer deleteTeacher(Integer userid) {
		return adminMapper.deleteTeacher(userid);
	}
	
	/**
	 * 查询班级信息
	 * @param curPage
	 * @param limit
	 * @return
	 */
	public Page<Clazz> clazz(String curPage, Integer limit) {
		HashMap<String, Object> params = new HashMap<>();

		// 获得总记录数
		int clazzTotal = adminMapper.clazzTotal();
		if (clazzTotal != 0) {
			// 创建page对象
			Page<Clazz> page = new Page<>(curPage, clazzTotal, limit);
			// 获得起始索引
			int index = (page.getCurPage() - 1) * limit;
			params.put("index", index);
			params.put("limit", limit);

			// 根据条件查询员工信息
			List<Clazz> clazz = adminMapper.clazz(params);
			page.setList(clazz);
			return page;
		}
		return null;
	}
	
	/**
	 * 添加班级
	 * @param clazz
	 * @return
	 */
	public Integer addClass(Clazz clazz) {
		return adminMapper.addClass(clazz);

	}
}
