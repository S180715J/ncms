package com.newer.ncms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
/**
 * 教师模块控制层
 * @author ZhangXin
 *
 */

import com.newer.ncms.service.TeacherService;
@RestController
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
}
