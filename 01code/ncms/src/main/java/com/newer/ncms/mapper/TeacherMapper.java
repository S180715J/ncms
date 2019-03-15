package com.newer.ncms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.newer.ncms.pojo.Student;

/**
 * 教师模块数据访问层
 * @author ZhangXin
 *
 */
@Repository
public interface TeacherMapper {
	/**
	 * 查询所有学生信息
	 * @param index
	 * @param limit
	 * @return 学生集合
	 */
	@Select("SELECT s.STUID,s.STUCODE,s.NAME,d.`DICNAME`AS SEX,c.`CODE`,\r\n" + 
			"d2.`DICNAME`AS SPECIALTY,d3.`DICNAME` AS SCHOOLAREA,s.`CONTACT`,d4.`DICNAME` ISDEBT,\r\n" + 
			"s.`JOBCITY`,s.`JOBCOMPANY`,s.`JOBSAL`,s.`JOB` FROM t_student s \r\n" + 
			"LEFT JOIN t_class c ON s.`CLASSID`=c.`CLASSID` \r\n" + 
			"LEFT JOIN t_dict d ON s.`SEX`=d.`DICTID` AND d.`DICTTYPE`='sex'\r\n" + 
			"LEFT JOIN T_DICT d2 ON s.`SPECIALTY`=d2.`DICTID` AND d2.`DICTTYPE`='specialty' \r\n" + 
			"LEFT JOIN T_DICT d3 ON s.`SCHOOLAREA`=d3.`DICTID` AND d3.`DICTTYPE`='school_area'\r\n" + 
			"LEFT JOIN T_DICT d4 ON s.`ISDEBT`=d4.`DICTID` AND d4.`DICTTYPE`='isdebt' LIMIT #{index},#{limit}")
	@Results({
		@Result(property="stuid",column="stuid",javaType=Integer.class),
		@Result(property="stucode",column="stucode",javaType=String.class),
		@Result(property="name",column="name",javaType=String.class),
		@Result(property="sex",column="sex",javaType=Integer.class),
		@Result(property="clazz.code",column="code",javaType=Integer.class),
		@Result(property="specialty",column="specialty",javaType=Integer.class),
		@Result(property="schoolarea",column="schoolarea",javaType=Integer.class),
		@Result(property="contact",column="contact",javaType=String.class),
		@Result(property="isdebt",column="isdept",javaType=Integer.class),
		@Result(property="jobcity",column="jobcity",javaType=String.class),
		@Result(property="jobcompany",column="jobcompany",javaType=String.class),
		@Result(property="jobsal",column="jobsal",javaType=String.class),
		@Result(property="job",column="job",javaType=String.class)
	})
	List<Student> students(@Param("index") Integer index,@Param("limit")Integer limit);
}
