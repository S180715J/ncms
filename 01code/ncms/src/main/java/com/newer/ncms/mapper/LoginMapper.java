package com.newer.ncms.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.newer.ncms.pojo.Role;
import com.newer.ncms.pojo.User;

/**
 * 登录数据接口层
 * @author ZhangXin
 *
 */
@Repository
public interface LoginMapper {
	@Select("SELECT USERID,USERNAME,REALNAME,NICKNAME,PASSWORD,u.CRTIME,ISDELETE,SEX,PHONE,EMAIL,r.ROLEID,r.`ROLENAME`,DEPT FROM t_user u LEFT JOIN t_role r  ON u.`ROLEID`=r.`ROLEID` WHERE USERNAME=#{username}AND PASSWORD=#{password}")
	 @Results({@Result(property = "userid", column = "userid", javaType = Integer.class),
		@Result(property = "username", column = "username", javaType = String.class),
		@Result(property = "realname", column = "realname", javaType = String.class),
		@Result(property = "nickname", column = "nickname", javaType = String.class),
		@Result(property = "password", column = "password", javaType = String.class),
		@Result(property = "crtime", column = "crtime", javaType = Date.class),
		@Result(property = "isdelete.dictid", column = "isdelete", javaType = String.class),
		@Result(property = "sex.dictid", column = "sex", javaType = String.class),
		@Result(property = "phone", column = "phone", javaType = String.class),
		@Result(property = "email", column = "email", javaType = String.class),
		@Result(property = "role.roleid", column = "roleid", javaType = Integer.class),
		@Result(property = "role.rolename", column = "rolename", javaType = String.class),
		@Result(property = "dept.dictid", column = "dept", javaType = String.class) })
	User login(User user);
}
