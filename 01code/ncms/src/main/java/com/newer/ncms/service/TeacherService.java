package com.newer.ncms.service;
/**
 * 教师模块业务逻辑层
 * @author ZhangXin
 *
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newer.ncms.mapper.TeacherMapper;
import com.newer.ncms.pojo.Student;
@Service
public class TeacherService {
	@Autowired
	private TeacherMapper teacherMapper;
	
	/**
	 * 查询所有学生信息
	 * @param index
	 * @param limit
	 * @return
	 */
	public List<Student> students(Integer index,Integer limit){
		return teacherMapper.students(index,limit);
	}
}
