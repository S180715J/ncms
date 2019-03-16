package com.newer.ncms.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.newer.ncms.pojo.Clazz;

@Repository
public interface AdminMapper {
	
	/**
	 * 查询教师信息
	 * @param params
	 * @return
	 */
	@Select("SELECT u.`USERID`,u.`USERNAME`,u.`REALNAME`,d.`DICNAME` SEX,d.`DICNAME` DEPT,u.`PHONE`,u.`EMAIL`FROM t_user u \r\n" + 
			"LEFT JOIN t_dict d ON u.`SEX`=d.`DICTID`AND d.`DICTTYPE`='sex' \r\n" + 
			"LEFT JOIN t_dict d1 ON u.`DEPT`=d.`DICTID` AND d.`DICTTYPE`='school_area' WHERE u.`ROLEID`=8 LIMIT #{index},#{limit}")
	@Results({
		@Result(property="user.userid",column="userid",javaType=Integer.class),
		@Result(property="user.username",column="username",javaType=String.class),
		@Result(property="user.realname",column="realname",javaType=String.class),
		@Result(property="user.sex",column="sex",javaType=Integer.class),
		@Result(property="schoolarea",column="schoolarea",javaType=Integer.class),
		@Result(property="contact",column="contact",javaType=String.class),
		@Result(property="homeaddress",column="homeaddress",javaType=String.class),
		@Result(property="postcode",column="postcode",javaType=String.class)
	})
	List<Clazz> clazzs(HashMap<String, Object> params); 

}
