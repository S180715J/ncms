package com.newer.ncms.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
		// System.out.println(list);
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
		System.out.println("addstudent===" + student);
		int addStudent = teacherService.addStudent(student);
		System.err.println("控制层" + addStudent);
		if (addStudent > 0) {
			return "ok";
		}
		return null;
	}

	/**
	 * 删除学生
	 * 
	 * @param stuid
	 * @return
	 */
	@RequestMapping(value = "/delStudent", method = RequestMethod.DELETE)
	public String delStudent(String ids) {
		// System.out.println(ids);
		String id[] = ids.split(",");
		int[] arr = new int[id.length];
		for (int i = 0; i < id.length; i++) {
			arr[i] = Integer.parseInt(id[i]);
			int delStudent = teacherService.delStudent(arr[i]);
			if (delStudent <= 0) {
				return "fail";
			}
		}

		return "ok";

	}

	/**
	 * 修改学生信息回显数据
	 * @param stuid
	 * @return
	 */
	@RequestMapping(value = "/showStudent/{stuid}", method = RequestMethod.GET)
	public ResponseEntity<?> showStudent(@PathVariable("stuid")Integer stuid) {
		
		Student showStudent = teacherService.showStudent(stuid);
		if (showStudent != null) {
			return new ResponseEntity<>(showStudent, HttpStatus.OK);
		}
		return null;

	}

	/**
	 * 跟新学生
	 * 
	 * @param student
	 * @return
	 */
	@RequestMapping(value = "/updStudent", method = RequestMethod.PUT)
	public String updStudent(Student student) {
		int updStudent = teacherService.updStudent(student);
		System.out.println(student);
		if (updStudent > 0) {
			return "ok";
		} else {
			return "fail";
		}
	}

}
