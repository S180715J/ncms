package com.newer.ncms.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.newer.ncms.pojo.Role;
import com.newer.ncms.pojo.User;

public interface SadminMapper {

	/**
	 * .返回所有角色信息
	 * 
	 * @return
	 */
	@Select("SELECT `ROLEID`,`ROLENAME`,`ROLEDESC` FROM `t_role`")
	public List<Role> selectRole();

	/**
	 * .返回所有管理员信息
	 * 
	 * @return
	 */
	@Select("SELECT `USERID`,`USERNAME`,`REALNAME`,`NICKNAME`,`ROLENAME` FROM `t_user` a LEFT JOIN `t_role` b ON a.`ROLEID`=b.`ROLEID` limit #{index},#{limit}")
	@Results({ @Result(property = "userid", column = "userid", javaType = Integer.class),
			@Result(property = "username", column = "username", javaType = String.class),
			@Result(property = "realname", column = "realname", javaType = String.class),
			@Result(property = "nickname", column = "nickname", javaType = String.class),
			@Result(property = "role.rolename", column = "rolename", javaType = String.class) })
	public List<User> selectAdmin(HashMap<String, Object> params);

	@Select("SELECT COUNT(*) FROM t_user")
	public int adminSum();
}
