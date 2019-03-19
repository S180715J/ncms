package com.newer.ncms.mapper;

import java.util.HashMap;
import java.util.List;

import javax.xml.crypto.Data;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

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
	 * 查询所有教师的总数
	 * @return
	 */
	@Select("SELECT COUNT(*) FROM T_user where roleid=8")
	int teacherTotal();
	
	/**
	 * 查询所在校区
	 * @return List<Dict>
	 */
	@Select("SELECT DICTTYPE,DICTID,DICNAME,SORTNO,REMARK FROM t_dict WHERE DICTTYPE='school_area'")
	List<Dict> schoolareas();
	
	
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
	@Insert("INSERT INTO t_user(USERNAME,REALNAME,NICKNAME,PASSWORD,SEX,PHONE,EMAIL,DEPT)VALUES(#{username},#{realname},#{nickname},#{password},#{sex.dictid},#{phone},#{email},#{dept.dictid})")
	Integer addTescher(User user);
 
	/**
	 * 添加班级
	 * @param classid
	 * @param userid
	 * @return
	
	@Insert("INSERT INTO t_class_user_rel(CLASSID,USERID)VALUES((SELECT CLASSID FROM t_class WHERE CLASSID=#{classid}),(SELECT USERID FROM t_user WHERE USERID=#{userid}))")
	int addClazz(Integer classid,Integer userid) ;
	 */
	
	
}
