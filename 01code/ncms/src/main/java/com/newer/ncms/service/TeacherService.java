package com.newer.ncms.service;
/**
 * 教师模块业务逻辑层
 * @author ZhangXin
 *
 */

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newer.ncms.mapper.TeacherMapper;
import com.newer.ncms.model.Page;
import com.newer.ncms.pojo.Clazz;
import com.newer.ncms.pojo.Dict;
import com.newer.ncms.pojo.Student;

@Service
public class TeacherService {
	@Autowired
	private TeacherMapper teacherMapper;

	/**
	 * 分页查询所有学生信息
	 * 
	 * @param curPage
	 * @param limit
	 * @return
	 */
	public Page<Student> students(String curPage, Integer limit) {
		HashMap<String, Object> params = new HashMap<>();
		// 获得总记录数
		int totalrows = teacherMapper.studentTotal();
		if (totalrows != 0) {
			// 创建page对象
			Page<Student> page = new Page<>(curPage, totalrows, limit);
			// 获得起始索引
			int index = (page.getCurPage() - 1) * limit;
			params.put("index", index);
			params.put("limit", limit);
			// 根据条件查询学生信息
			List<Student> list = teacherMapper.students(params);
			page.setList(list);
			return page;
		}
		return null;
	}
	
	
	/**
	 * 查询班级编号和名称
	 * @return List<Clazz>
	 */
	public List<Clazz> clazzs(){
		return teacherMapper.clazzs();
	}
	
	
	/**
	 * 查询专业方向
	 * @return List<Dict>
	 */
	public List<Dict> specialtys(){
		return teacherMapper.specialtys();
	}
	
	/**
	 * 查询所在校区
	 * @return List<Dict>
	 */
	public List<Dict> schoolareas(){
		return teacherMapper.schoolareas();
	}
	
	
	/**
	 * 查询文化程度
	 * @return List<Dict>
	 */
	public List<Dict> educations(){
		return teacherMapper.educations();
	}
	
	
	/**
	 * 添加学生
	 * @param student
	 * @return
	 */
	public int addStudent(Student student) {
		return teacherMapper.addStudent(student);
	}
	
	
	
	
	
	
}
