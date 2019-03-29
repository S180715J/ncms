package com.newer.ncms.mapper;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.newer.ncms.pojo.Clazz;
import com.newer.ncms.pojo.Dict;
import com.newer.ncms.pojo.Role;
import com.newer.ncms.pojo.User;

/**
 * 管理员模块数据访问层
 * @author yuanyonghong
 *
 */
@Repository
public interface AdminMapper {
	
	/**
	 * 查询教师信息
	 * @param params
	 * @return
	 */
	@Select("SELECT u.`USERID`,u.`USERNAME`,u.`REALNAME`,d.`DICNAME` SEX,d1.`DICNAME` DEPT,u.`PHONE`,u.`EMAIL`FROM t_user u \r\n" + 
			"LEFT JOIN t_dict d ON u.`SEX`=d.`DICTID`AND d.`DICTTYPE`='sex' \r\n" + 
			"LEFT JOIN t_dict d1 ON u.`DEPT`=d1.`DICTID` AND d1.`DICTTYPE`='school_area' WHERE u.`ROLEID`=8 LIMIT #{index},#{limit}")
	@Results({
		@Result(property="userid",column="userid",javaType=Integer.class),
		@Result(property="username",column="username",javaType=String.class),
		@Result(property="realname",column="realname",javaType=String.class),
		@Result(property="sex.dicname",column="sex",javaType=String.class),
		@Result(property="dept.dicname",column="dept",javaType=String.class),
		@Result(property="phone",column="phone",javaType=String.class),
		@Result(property="email",column="email",javaType=String.class)
	})
	List<User> tescher(HashMap<String, Object> params); 
	
	
	/**
	 * 带条件查询教师信息
	 * @param params
	 * @return
	 */
	List<User> queryTeacher(HashMap<String, Object> params);
	
	/**
	 * 查询所有教师的总数
	 * @return
	 */
	@Select("SELECT COUNT(*) FROM T_user where roleid=8")
	int teacherTotal();
	
	/**
	 * 带条件查询总数
	 * @return
	 */
	int getTotalRecordNo(HashMap<String, Object> params);
	/**
	 * 查询所在校区
	 * @return List<Dict>
	 */
	@Select("SELECT DICTTYPE,DICTID,DICNAME,SORTNO,REMARK FROM t_dict WHERE DICTTYPE='school_area'")
	List<Dict> schoolareas();
	
	/**
	 * 查询专业方向
	 * @return
	 */
	@Select("SELECT DICTTYPE,DICTID,DICNAME,SORTNO,REMARK FROM t_dict WHERE DICTTYPE='specialty'")
	List<Dict> specialty();
	
	/**
	 * 查询班级状态
	 * @return
	 */
	@Select("SELECT DICTTYPE,DICTID,DICNAME,SORTNO,REMARK FROM t_dict WHERE DICTTYPE='class_status'")
	List<Dict> classStatus();
	/**
	 * 查询角色
	 * @return
	 */
	@Select("SELECT ROLEID,ROLENAME,ROLECODE,ROLEDESC,CRTIME FROM t_role")
	List<Role> queryRole();
	
	/**
	 * 添加教师
	 * @param user
	 * @return 
	 */
	@Insert("INSERT INTO t_user(USERNAME,REALNAME,NICKNAME,PASSWORD,CRTIME,SEX,PHONE,EMAIL,ROLEID,DEPT)VALUES(#{username},#{realname},#{nickname},#{password},#{crtime},#{sex.dictid},#{phone},#{email},#{role.roleid},#{dept.dictid})")
	Integer addTeacher(User user);
	
	
	/**
	 * 根据id删除教师
	 * @param userid
	 * @return
	 */
	@Delete("DELETE  FROM t_user WHERE USERID=#{userid}")
	Integer delTeacher(Integer userid);
	
	/**
	 * 修改教师
	 * @param user
	 * @return
	 */
	@Update("UPDATE t_user SET USERNAME=#{username},REALNAME=#{realname},NICKNAME=#{nickname},SEX=#{sex.dictid},PHONE=#{phone},EMAIL=#{email} WHERE USERID=#{userid}")
	int upTeacher(User user);
	
	/**
	 * 根据id回显教师信息
	 * @param stuid
	 * @return
	 */
	@Select("SELECT USERID,USERNAME,REALNAME,NICKNAME,SEX,PHONE,EMAIL,ROLEID,DEPT FROM t_user WHERE USERID=#{userid}")
	@Results({ 
		@Result(property="userid",column="userid",javaType=Integer.class),
		@Result(property="username",column="username",javaType=String.class),
		@Result(property="realname",column="realname",javaType=String.class),
		@Result(property="sex.dictid",column="sex",javaType=String.class),
		@Result(property="dept.dictid",column="dept",javaType=String.class),
		@Result(property="phone",column="phone",javaType=String.class),
		@Result(property="email",column="email",javaType=String.class),
		@Result(property="role.roleid",column="roleid",javaType=Integer.class)
		})
	User showTeacher(Integer userid);
	
	
	/**
	 * 查询班级
	 * @param cparams
	 * @return
	 */
	@Select("select c.`CLASSID`,c.`CODE`,d.`DICNAME` SCHOOLAREA,d1.`DICNAME` SPECIALTY,c.`BEGINDATE`,c.`ENDDATE`,c.`INITCOUNT`,c.`ONLINECOUNT`,d2.`DICNAME` STATUS,c.`ENDCOUNT`,c.`EXAMCOUNT`,c.`PASSCOUNT`,c.`JOBCOUNT`,c.`PRAISECOUNT`,c.`MISSCOUNT`,d3.`DICNAME` ISDELETE from t_class c\r\n" + 
			"left join t_dict d on c.`SCHOOLAREA`=d.`DICTID` and d.`DICTTYPE`='school_area'\r\n" + 
			"LEFT JOIN t_dict d1 ON c.`SPECIALTY`=d1.`DICTID` AND d1.`DICTTYPE`='specialty'\r\n" + 
			"LEFT JOIN t_dict d2 ON c.`STATUS`=d2.`DICTID` and d2.`DICTTYPE`='class_status'\r\n" + 
			"LEFT JOIN t_dict d3 ON c.`ISDELETE`=d3.`DICTID` AND d3.`DICTTYPE`='isdelete' LIMIT #{index},#{limit}")
	@Results({
		@Result(property="classid",column="classid",javaType=Integer.class),
		@Result(property="code",column="code",javaType=String.class),
		@Result(property="schoolarea.dicname",column="schoolarea",javaType=String.class),
		@Result(property="specialty.dicname",column="specialty",javaType=String.class),
		@Result(property="begindate",column="begindate",javaType=Date.class),
		@Result(property="enddate",column="enddate",javaType=Date.class),
		@Result(property="initcount",column="initcount",javaType=Integer.class),
		@Result(property="onlinecount",column="onlinecount",javaType=Integer.class),
		@Result(property="status.dicname",column="status",javaType=String.class),
		@Result(property="endcount",column="endcount",javaType=Integer.class),
		@Result(property="examcount",column="examcount",javaType=Integer.class),
		@Result(property="passcount",column="passcount",javaType=String.class),
		@Result(property="jobcount",column="jobcount",javaType=Integer.class),
		@Result(property="praisecount",column="praisecount",javaType=Integer.class),
		@Result(property="misscount",column="misscount",javaType=Integer.class)
	}) 
	List<Clazz> clazz(HashMap<String, Object> params); 
	
	/**
	 * 查询班级总数
	 * @return
	 */
	@Select("SELECT COUNT(*) FROM t_class")
	int clazzTotal();
	
	/**
	 * 带条件查询班级信息
	 * @param params
	 * @return
	 */
	List<Clazz> queryClass(HashMap<String, Object> params);
	
	/**
	 * 带条件查询总数
	 * @return
	 */
	int getTotalClassRecords(HashMap<String, Object> params);
	
	/**
	 * 添加班级
	 * @param classid
	 * @return
	 */
	@Insert("INSERT INTO t_class(CODE,SCHOOLAREA,SPECIALTY,BEGINDATE,ENDDATE,INITCOUNT,ONLINECOUNT,STATUS,ENDCOUNT,EXAMCOUNT,PASSCOUNT,JOBCOUNT,PRAISECOUNT,MISSCOUNT)VALUES(#{code},#{schoolarea.dictid},#{specialty.dictid},#{begindate},#{enddate},#{initcount},#{onlinecount},#{status.dictid},#{endcount},#{examcount},#{passcount},#{jobcount},#{praisecount},#{misscount})")
	Integer addClass(Clazz clazz);
	
	/**
	 * 根据id删除班级
	 * @param classid
	 * @return
	 */
	@Delete("DELETE  FROM t_class WHERE CLASSID=#{classid}")
	Integer delClass(Integer classid);
	
	/**
	 * 更新班级
	 * @param clazz
	 * @return
	 */
	@Update("UPDATE t_class SET CODE=#{code},SCHOOLAREA=#{schoolarea.dictid},SPECIALTY=#{specialty.dictid},BEGINDATE=#{begindate},ENDDATE=#{enddate},\r\n" + 
			"INITCOUNT=#{initcount},ONLINECOUNT=#{onlinecount},STATUS=#{status.dictid},ENDCOUNT=#{endcount},EXAMCOUNT=#{examcount},PASSCOUNT=#{passcount},MISSCOUNT=#{misscount} WHERE CLASSID=#{classid}")
	int upClass(Clazz clazz);
	
	/**
	 * 回显班级信息
	 * @param classid
	 * @return
	 */
	@Select("select CLASSID,code,SCHOOLAREA,SPECIALTY,BEGINDATE,ENDDATE,INITCOUNT,ONLINECOUNT,STATUS,ENDCOUNT,EXAMCOUNT,PASSCOUNT,JOBCOUNT,PRAISECOUNT,MISSCOUNT from t_class where CLASSID=#{classid}")
	@Results({
		@Result(property="classid",column="classid",javaType=Integer.class),
		@Result(property="code",column="code",javaType=String.class),
		@Result(property="schoolarea.dictid",column="schoolarea",javaType=String.class),
		@Result(property="specialty.dictid",column="specialty",javaType=String.class),
		@Result(property="begindate",column="begindate",javaType=Date.class),
		@Result(property="enddate",column="enddate",javaType=Date.class),
		@Result(property="initcount",column="initcount",javaType=Integer.class),
		@Result(property="onlinecount",column="onlinecount",javaType=Integer.class),
		@Result(property="status.dictid",column="status",javaType=String.class),
		@Result(property="endcount",column="endcount",javaType=Integer.class),
		@Result(property="examcount",column="examcount",javaType=Integer.class),
		@Result(property="passcount",column="passcount",javaType=String.class),
		@Result(property="jobcount",column="jobcount",javaType=Integer.class),
		@Result(property="praisecount",column="praisecount",javaType=Integer.class),
		@Result(property="misscount",column="misscount",javaType=Integer.class)
	})
	Clazz showClass(Integer classid);
}
