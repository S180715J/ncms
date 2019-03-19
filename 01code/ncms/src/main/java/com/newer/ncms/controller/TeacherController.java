package com.newer.ncms.controller;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * 教师模块控制层
 * @author ZhangXin
 *
 */

import com.newer.ncms.model.Page;
import com.newer.ncms.pojo.Clazz;
import com.newer.ncms.pojo.Dict;
import com.newer.ncms.pojo.Student;
import com.newer.ncms.service.TeacherService;
import com.newer.ncms.utils.JwtTokenUtil;

@RestController
public class TeacherController {

	@Autowired
	private TeacherService teacherService;

	/**
	 * 返回所有学生信息
	 * 
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public ResponseEntity<?> students(@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "limit", required = false, defaultValue = "3") Integer limit) {
		Page<Student> data = teacherService.students(page, limit);
		ResponseEntity<?> entity = null;
		if (data != null) {
			entity = new ResponseEntity<>(data, HttpStatus.OK);
		}
		return entity;
	}

	/**
	 * 专业方向、所属院校、文化水平下拉框
	 * 
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<?> data() {
		List<Dict> specialtys = teacherService.specialtys();
		List<Dict> schoolareas = teacherService.schoolareas();
		List<Dict> educations = teacherService.educations();
		List<List<?>> list = new ArrayList<>();
		list.add(specialtys);
		list.add(schoolareas);
		list.add(educations);
		//System.out.println(list);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	/**
	 * 班级下拉框
	 * 
	 * @return
	 */
	@RequestMapping(value = "/clazzs", method = RequestMethod.GET)
	public ResponseEntity<?> clazzs() {
		List<Clazz> clazzs = teacherService.clazzs();
		return new ResponseEntity<>(clazzs, HttpStatus.OK);
	}

	/**
	 * 添加学生
	 * 
	 * @param student
	 * @return
	 */
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public String addStudent(Student student) {
		System.out.println("addstudent==="+student);
		int addStudent = teacherService.addStudent(student);
		System.err.println("控制层"+addStudent);
		if (addStudent > 0) {
			return "ok";
		}
		return null;
	}
	
	
	

}
