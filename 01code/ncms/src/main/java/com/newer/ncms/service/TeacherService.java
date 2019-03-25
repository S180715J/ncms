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
import com.newer.ncms.pojo.Channel;
import com.newer.ncms.pojo.Clazz;
import com.newer.ncms.pojo.Dict;
import com.newer.ncms.pojo.Document;
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
	 * .带条件查询学生数据集合的page对象
	 * 
	 * @return 根据查询的条件返回相应的page对象
	 */
	public Page<Student> queryStudent(HashMap<String, Object> params, String curPage, Integer limit) {

		// 查询数据库中的总记录数
		int totalRecordNo = teacherMapper.getTotalRecordNo(params);

		// pageSize常量

		// 创建page对象
		Page<Student> page = new Page<>(curPage, totalRecordNo, limit);

		// 先拿到修正后的pageNo
		int index = (page.getCurPage() - 1) * limit;
		params.put("index", index);
		params.put("limit", limit);
		System.out.println("params" + params);
		// 查询数据库中的数据
		List<Student> list = teacherMapper.queryStudent(params);
		// 将数据集合放入page中
		page.setList(list);

		return page;
	}

	/**
	 * 查询班级编号和名称
	 * 
	 * @return List<Clazz>
	 */
	public List<Clazz> clazzs() {
		return teacherMapper.clazzs();
	}

	/**
	 * 查询专业方向
	 * 
	 * @return List<Dict>
	 */
	public List<Dict> specialtys() {
		return teacherMapper.specialtys();
	}

	/**
	 * 查询所在校区
	 * 
	 * @return List<Dict>
	 */
	public List<Dict> schoolareas() {
		return teacherMapper.schoolareas();
	}

	/**
	 * 查询文化程度
	 * 
	 * @return List<Dict>
	 */
	public List<Dict> educations() {
		return teacherMapper.educations();
	}

	/**
	 * 添加学生
	 * 
	 * @param student
	 * @return
	 */
	public int addStudent(Student student) {
		return teacherMapper.addStudent(student);
	}

	/**
	 * 删除学生
	 * 
	 * @param stuid
	 * @return
	 */
	public int delStudent(Integer stuid) {
		return teacherMapper.delStudent(stuid);
	}

	/**
	 * 跟新学生信息
	 * 
	 * @param student
	 * @return
	 */
	public int updStudent(Student student) {
		return teacherMapper.updStudent(student);
	}

	/**
	 * 回显修改学生信息
	 * 
	 * @param stuid
	 * @return
	 */
	public Student showStudent(Integer stuid) {
		return teacherMapper.showStudent(stuid);
	}

	/**
	 * 分页查询所有文章信息
	 * 
	 * @param curPage
	 * @param limit
	 * @return
	 */
	public Page<Document> documents(String curPage, Integer limit) {
		HashMap<String, Object> params = new HashMap<>();
		// 获得总记录数
		int totalrows = teacherMapper.documentSum();
		if (totalrows != 0) {
			// 创建page对象
			Page<Document> page = new Page<>(curPage, totalrows, limit);
			// 获得起始索引
			int index = (page.getCurPage() - 1) * limit;
			params.put("index", index);
			params.put("limit", limit);
			// 根据条件查询学生信息
			List<Document> list = teacherMapper.documents(params);
			page.setList(list);
			return page;
		}
		return null;
	}

	/**
	 * .带条件查询文章数据集合的page对象
	 * 
	 * @return 根据查询的条件返回相应的page对象
	 */
	public Page<Document> queryDocument(HashMap<String, Object> params, String curPage, Integer limit) {

		// 查询数据库中的总记录数
		int queryDocumentSum = teacherMapper.queryDocumentSum();

		// pageSize常量

		// 创建page对象
		Page<Document> page = new Page<>(curPage, queryDocumentSum, limit);

		// 先拿到修正后的pageNo
		int index = (page.getCurPage() - 1) * limit;
		params.put("index", index);
		params.put("limit", limit);
		System.out.println("params" + params);
		// 查询数据库中的数据
		List<Document> list = teacherMapper.queryDocument(params);
		// 将数据集合放入page中
		page.setList(list);
		return page;
	}

	/**
	 * 根据id删除文章
	 * 
	 * @param docid
	 * @return
	 */
	public int delDocument(Integer docid) {
		return teacherMapper.delDocument(docid);
	}
	
	/**
	 * 查询频道
	 * @return
	 */
	public List<Channel> channels(){
		return teacherMapper.channels();
	}
	

}
