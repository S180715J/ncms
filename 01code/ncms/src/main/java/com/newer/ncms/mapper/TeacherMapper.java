package com.newer.ncms.mapper;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.newer.ncms.pojo.Channel;
import com.newer.ncms.pojo.Clazz;
import com.newer.ncms.pojo.Dict;
import com.newer.ncms.pojo.Document;
import com.newer.ncms.pojo.Student;

/**
 * 教师模块数据访问层
 * 
 * @author ZhangXin
 *
 */
@Repository
public interface TeacherMapper {

	/**
	 * 查询所有学生信息
	 * 
	 * @param params
	 * @return 学生集合
	 */
	@Select("SELECT s.STUID,s.STUCODE,s.NAME,d.`DICNAME`AS SEX,c.`CODE`,\r\n"
			+ "d2.`DICNAME`AS SPECIALTY,d3.`DICNAME` AS SCHOOLAREA,s.`CONTACT`,d4.`DICNAME` ISDEBT,\r\n"
			+ "s.`JOBCITY`,s.`JOBCOMPANY`,s.`JOBSAL`,s.`JOB` FROM t_student s \r\n"
			+ "LEFT JOIN t_class c ON s.`CLASSID`=c.`CLASSID` \r\n"
			+ "LEFT JOIN t_dict d ON s.`SEX`=d.`DICTID` AND d.`DICTTYPE`='sex'\r\n"
			+ "LEFT JOIN T_DICT d2 ON s.`SPECIALTY`=d2.`DICTID` AND d2.`DICTTYPE`='specialty' \r\n"
			+ "LEFT JOIN T_DICT d3 ON s.`SCHOOLAREA`=d3.`DICTID` AND d3.`DICTTYPE`='school_area'\r\n"
			+ "LEFT JOIN T_DICT d4 ON s.`ISDEBT`=d4.`DICTID` AND d4.`DICTTYPE`='isdebt' LIMIT #{index},#{limit}")
	@Results({ @Result(property = "stuid", column = "stuid", javaType = Integer.class),
			@Result(property = "stucode", column = "stucode", javaType = String.class),
			@Result(property = "name", column = "name", javaType = String.class),
			@Result(property = "sex.dicname", column = "sex", javaType = String.class),
			@Result(property = "clazz.code", column = "code", javaType = String.class),
			@Result(property = "specialty.dicname", column = "specialty", javaType = String.class),
			@Result(property = "schoolarea.dicname", column = "schoolarea", javaType = String.class),
			@Result(property = "contact", column = "contact", javaType = String.class),
			@Result(property = "isdebt.dicname", column = "isdebt", javaType = String.class),
			@Result(property = "jobcity", column = "jobcity", javaType = String.class),
			@Result(property = "jobcompany", column = "jobcompany", javaType = String.class),
			@Result(property = "jobsal", column = "jobsal", javaType = Double.class),
			@Result(property = "job", column = "job", javaType = String.class) })
	List<Student> students(HashMap<String, Object> params);

	/**
	 * 查询学生信息 带条件查询的
	 * 
	 * @param params
	 * @return
	 */
	List<Student> queryStudent(HashMap<String, Object> params);

	/**
	 * .带查询条件的，查询总记录数
	 * 
	 * @param params
	 * @return
	 */
	int getTotalRecordNo(HashMap<String, Object> params);

	/**
	 * 查询所有学生的总数
	 * 
	 * @return
	 */
	@Select("SELECT COUNT(*) FROM T_STUDENT")
	int studentTotal();

	/**
	 * 查询班级编号和名称
	 * 
	 * @return List<Clazz>
	 */
	@Select("SELECT CLASSID,CODE FROM t_class")
	List<Clazz> clazzs();

	/**
	 * 查询专业方向
	 * 
	 * @return List<Dict>
	 */
	@Select("SELECT DICTTYPE,DICTID,DICNAME,SORTNO,REMARK FROM t_dict WHERE DICTTYPE='specialty'")
	List<Dict> specialtys();

	/**
	 * 查询所在校区
	 * 
	 * @return List<Dict>
	 */
	@Select("SELECT DICTTYPE,DICTID,DICNAME,SORTNO,REMARK FROM t_dict WHERE DICTTYPE='school_area'")
	List<Dict> schoolareas();

	/**
	 * 查询文化程度
	 * 
	 * @return List<Dict>
	 */
	@Select("SELECT DICTTYPE,DICTID,DICNAME,SORTNO,REMARK FROM t_dict WHERE DICTTYPE='education'")
	List<Dict> educations();

	/**
	 * 添加学生
	 * 
	 * @param student
	 * @return
	 */
	@Insert("INSERT INTO t_student(STUCODE,PASSWORD,NAME,PINYING,SEX,CLASSID,SPECIALTY,SCHOOLAREA,NATION,IDCARD,EDU,ENDSCHOOL,CONTACT,HOMECONTACT,HOMEADDRESS,POSTCODE,QQ,ISDEBT,JOBCITY,JOBCOMPANY,JOBSAL,job,REMARK,isdelete)VALUES(#{stucode},#{password},#{name},#{pinying},#{sex.dictid},#{clazz.classid},#{specialty.dictid},#{schoolarea.dictid},#{nation},#{idcard},#{edu.dictid},#{endschool},#{contact},#{homecontact},#{homeaddress},#{postcode},#{qq},#{isdebt.dictid},#{jobcity},#{jobcompany},#{jobsal},#{job},#{remark},#{isdelete.dictid})")
	int addStudent(Student student);

	/**
	 * 删除学生
	 * 
	 * @param stuid
	 * @return
	 */
	@Delete("DELETE FROM t_student WHERE stuid=#{stuid}")
	int delStudent(Integer stuid);

	/**
	 * 修改学生信息回显
	 * 
	 * @param stuid
	 * @return
	 */
	@Select("SELECT STUID,STUCODE,NAME,PINYING,SEX,CLASSID,SPECIALTY,SCHOOLAREA,NATION,IDCARD,EDU,ENDSCHOOL,CONTACT,HOMECONTACT,HOMEADDRESS,POSTCODE,QQ,ISDEBT,JOBCITY,JOBCOMPANY,JOBSAL,job,REMARK,isdelete FROM t_student WHERE stuid=#{stuid}")
	@Results({ @Result(property = "stuid", column = "stuid", javaType = Integer.class),
			@Result(property = "stucode", column = "stucode", javaType = String.class),
			@Result(property = "name", column = "name", javaType = String.class),
			@Result(property = "pinying", column = "pinying", javaType = String.class),
			@Result(property = "sex.dictid", column = "sex", javaType = String.class),
			@Result(property = "clazz.classid", column = "classid", javaType = Integer.class),
			@Result(property = "specialty.dictid", column = "specialty", javaType = String.class),
			@Result(property = "schoolarea.dictid", column = "schoolarea", javaType = String.class),
			@Result(property = "nation", column = "nation", javaType = String.class),
			@Result(property = "idcard", column = "idcard", javaType = String.class),
			@Result(property = "edu.dictid", column = "edu", javaType = String.class),
			@Result(property = "endschool", column = "endschool", javaType = String.class),
			@Result(property = "contact", column = "contact", javaType = String.class),
			@Result(property = "homecontact", column = "homecontact", javaType = String.class),
			@Result(property = "homeaddress", column = "homeaddress", javaType = String.class),
			@Result(property = "postcode", column = "postcode", javaType = String.class),
			@Result(property = "qq", column = "qq", javaType = String.class),
			@Result(property = "isdebt.dictid", column = "isdebt", javaType = String.class),
			@Result(property = "jobcity", column = "jobcity", javaType = String.class),
			@Result(property = "jobcompany", column = "jobcompany", javaType = String.class),
			@Result(property = "jobsal", column = "jobsal", javaType = Double.class),
			@Result(property = "job", column = "job", javaType = String.class),
			@Result(property = "remark", column = "remark", javaType = String.class),
			@Result(property = "isdelete.dictid", column = "isdelete", javaType = String.class) })
	Student showStudent(Integer stuid);

	/**
	 * 跟新学生信息
	 * 
	 * @param student
	 * @return
	 */
	@Update("UPDATE t_student SET STUCODE=#{stucode},NAME=#{name},PINYING=#{pinying},SEX=#{sex.dictid},CLASSID=#{clazz.classid},SPECIALTY=#{specialty.dictid},SCHOOLAREA=#{schoolarea.dictid},NATION=#{nation},IDCARD=#{idcard},EDU=#{edu.dictid},ENDSCHOOL=#{endschool},CONTACT=#{contact},HOMECONTACT=#{homecontact},HOMEADDRESS=#{homeaddress},POSTCODE=#{postcode},QQ=#{qq},ISDEBT=#{isdebt.dictid},JOBCITY=#{jobcity},JOBCOMPANY=#{jobcompany},JOBSAL=#{jobsal},job=#{job},REMARK=#{remark},isdelete=#{isdelete.dictid} WHERE STUID=#{stuid}")
	int updStudent(Student student);

	/**
	 * 查询所有文章列表
	 * @return
	 */
	@Select("SELECT DOCID,DOCTITLE,c.`CHNLNAME`AS DOCCHANNEL,DOCVALID,u.`REALNAME`AS REALNAME,d1.`DICNAME` AS DOCSTATE,d2.`DICNAME` AS ISTOP,\r\n"
			+ "d3.`DICNAME`AS ISHIGHLIGHT,d4.`DICNAME`AS TYPEID \r\n"
			+ "FROM t_document d LEFT JOIN t_channel c ON d.`DOCCHANNEL`=c.`CHANNELID` \r\n"
			+ "LEFT JOIN t_user u ON d.`USERID`=u.`USERID` \r\n"
			+ "LEFT JOIN t_dict d1 ON d1.`DICTID`=d.`DOCSTATUS` AND d1.`DICTTYPE`='doc_state' \r\n"
			+ "LEFT JOIN t_dict d2 ON d2.`DICTID`=d.`ISTOP` AND d2.`DICTTYPE`='doc_top' \r\n"
			+ "LEFT JOIN t_dict d3 ON d3.`DICTID`=d.`ISHIGHLIGHT` AND d3.`DICTTYPE`='doc_highlight' \r\n"
			+ "LEFT JOIN t_dict d4 ON d4.`DICTID`=d.`TYPEID` AND d4.`DICTTYPE`='doc_publish_type'  LIMIT #{index},#{limit}")
	@Results({ @Result(column = "DOCID", property = "docid", javaType = Integer.class),
			@Result(column = "DOCTITLE", property = "doctitle", javaType = String.class),
			@Result(column = "DOCCHANNEL", property = "docchannel.chnlname", javaType = String.class),
			@Result(column = "REALNAME", property = "user.realname", javaType = String.class),
			@Result(column = "DOCVALID", property = "docvalid", javaType = Date.class),
			@Result(column = "DOCSTATE", property = "docstatus.dicname", javaType = String.class),
			@Result(column = "ISTOP", property = "istop.dicname", javaType = String.class),
			@Result(column = "ISHIGHLIGHT", property = "ishighlight.dicname", javaType = String.class),
			@Result(column = "TYPEID", property = "doctype.dicname", javaType = String.class), })
	List<Document> documents(HashMap<String, Object> params);
	
	/**
	 * 带条件查询文章
	 * @param params
	 * @return
	 */
	List<Document> queryDocument(HashMap<String, Object> params);
	
	/**
	 * 带条件查询总数
	 * @return
	 */
	int queryDocumentSum();
	
	/**
	 * 查询文档总数
	 * @return
	 */
	@Select("SELECT COUNT(*) FROM t_document")
	int  documentSum();
	
	/**
	 * 删除文档
	 * @param docid
	 * @return
	 */
	@Delete("DELETE FROM t_document WHERE DOCID=#{docid}")
	int delDocument(Integer docid);
	
	/**
	 * 查询频道
	 * @return
	 */
	@Select("SELECT CHANNELID,CHNLNAME,PARENTID FROM t_channel")
	List<Channel> channels();
	
}
