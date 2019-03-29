package com.newer.ncms.mapper;

import java.awt.Checkbox;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.newer.ncms.pojo.Channel;
import com.newer.ncms.pojo.Clazz;
import com.newer.ncms.pojo.Document;
import com.newer.ncms.pojo.Role;
import com.newer.ncms.pojo.User;
/**
 * 超级管理员数据接口层
 * @author ZhangXin
 *
 */
public interface SadminMapper {

	/**
	 * .返回所有角色信息
	 * 
	 * @return
	 */
	@Select("SELECT `ROLEID`,`ROLENAME`,`ROLEDESC` FROM `t_role`")
	public List<Role> selectRole();

	/**
	 * .查询管理员信息
	 * 
	 * @return
	 */
	@Select("SELECT u.`USERID`,u.`USERNAME`,u.`REALNAME`,u.`NICKNAME`,d.`DICNAME` SEX,R.`ROLENAME` ROLEID,u.`CRTIME`,d1.`DICNAME` DEPT,u.`PHONE`,u.`EMAIL`,d2.`DICNAME` ISDELETE FROM t_user u  \r\n" + 
			"LEFT JOIN t_dict d ON u.`SEX`=d.`DICTID`AND d.`DICTTYPE`='sex' \r\n" + 
			"LEFT JOIN t_dict d1 ON u.`DEPT`=d1.`DICTID` AND d1.`DICTTYPE`='school_area' \r\n" + 
			"LEFT JOIN t_dict d2 ON u.`ISDELETE`=d2.`DICTID` AND d2.`DICTTYPE`='isdelete' \r\n" + 
			"LEFT JOIN t_role r ON r.`ROLEID`=u.`ROLEID`  WHERE u.`ROLEID`=7 LIMIT #{index},#{limit}")
	@Results({ @Result(property = "userid", column = "userid", javaType = Integer.class),
			@Result(property = "username", column = "username", javaType = String.class),
			@Result(property = "realname", column = "realname", javaType = String.class),
			@Result(property = "nickname", column = "nickname", javaType = String.class),
			@Result(property = "sex.dicname", column = "sex", javaType = String.class),
			@Result(property = "role.rolename", column = "rolename", javaType = String.class),
			@Result(property = "crtime", column = "crtime", javaType = Date.class),
			@Result(property = "dept.dicname", column = "dept", javaType = String.class),
			@Result(property = "phone", column = "phone", javaType = String.class),
			@Result(property = "email", column = "email", javaType = String.class),
			@Result(property = "isdelete.dicname", column = "isdelete",javaType = String.class) 
	      })
	public List<User> selectAdmin(HashMap<String, Object> params);

	@Select("SELECT USERNAME FROM t_user WHERE USERNAME=#{username}")
	String check(String username);
	
	/**
	 * 添加管理员
	 * @param user
	 * @return
	 */
	@Insert("INSERT INTO t_user(USERNAME,PASSWORD,REALNAME,NICKNAME,CRTIME,SEX,DEPT,ROLEID,PHONE,EMAIL,ISDELETE)VALUES(#{username},#{password},#{realname},#{nickname},#{crtime},#{sex.dictid},#{dept.dictid},#{role.roleid},#{phone},#{email},#{isdelete.dictid})")
    int addSadmin(User user);
	
	/**
	 * 根据id删除管理员
	 * @param userid
	 * @return
	 */
	@Delete("DELETE FROM t_user WHERE userid=#{userid}")
	int delSadmin(Integer userid);
    
	/**
	 * 更新管理员
	 * @param user
	 * @return*/
	@Update("UPDATE t_user SET USERNAME=#{username},PASSWORD=#{password},REALNAME=#{realname},NICKNAME=#{nickname},CRTIME=#{crtime},SEX=#{sex.dictid},DEPT=#{dept.dictid},ROLEID=#{role.roleid},PHONE=#{phone},EMAIL=#{email},ISDELETE=#{isdelete.dictid} WHERE USERID=#{userid}")
	int upSadmin(User user);
	
	/**
	 * 根据id回显管理员信息
	 * @param userid
	 * @return
	 */
	@Select("SELECT USERID, USERNAME,PASSWORD,REALNAME,NICKNAME,CRTIME,SEX,DEPT,ROLEID,PHONE,EMAIL,ISDELETE FROM t_user WHERE USERID=#{userid}")
	@Results({ 
		@Result(property = "userid", column = "userid", javaType = Integer.class),
		@Result(property = "username", column = "username", javaType = String.class),
		@Result(property = "realname", column = "realname", javaType = String.class),
		@Result(property = "nickname", column = "nickname", javaType = String.class),
		@Result(property = "sex.dictid", column = "sex", javaType = String.class),
		@Result(property = "role.roleid", column = "roleid", javaType = Integer.class),
		@Result(property = "crtime", column = "crtime", javaType = Date.class),
		@Result(property = "dept.dictid", column = "dept", javaType = String.class),
		@Result(property = "phone", column = "phone", javaType = String.class),
		@Result(property = "email", column = "email", javaType = String.class),
		@Result(property = "isdelete.dictid", column = "isdelete",javaType = String.class) 
      })
	User showSadmin(Integer userid);
	
	/**
	 * .获得用户的总记录数
	 * 
	 * @return
	 */
	@Select("SELECT COUNT(*) FROM t_user")
	public int adminSum();

	/**
	 * 带条件查询管理员信息
	 * @param params
	 * @return
	 */
	List<User> querySadmin(HashMap<String, Object> params);
	
	/**
	 * 带条件查询总数
	 * @return
	 */
	int getTotalSadmin(HashMap<String, Object> params);
	
	
	/**
	 * .回显角色身份
	 * 
	 * @return
	 */
	@Select("SELECT ROLEID ,`ROLENAME` FROM `t_role`")
	public List<Role> selectIdentity();

	/**
	 * 查询所有频道信息
	 * 
	 * @return
	 */
	@Select("SELECT CHANNELID,CHNLNAME,CHNLDESC,CHNLNAMEPATH,CRTIME,PARENTID FROM t_channel LIMIT #{index},#{limit}")
	List<Channel> channels(HashMap<String, Object> params);

	/**
	 * 查询频道的总记录数
	 * 
	 * @return
	 */
	@Select("SELECT COUNT(*) FROM t_channel")
	int channelsSum();

	/**
	 * 插入频道
	 * 
	 * @return
	 */
	@Insert("INSERT INTO t_channel(CHNLNAME,CHNLDESC,CHNLNAMEPATH,PARENTID,CHNLORDER,CRTIME)VALUES(#{chnlname},#{chnldesc},#{chnlnamepath},#{parentid},#{chnlorder},#{crtime})")
	Integer addChannel(Channel channel);
	
	/**
	 * 查询父路径
	 * @param channelid
	 * @return
	 */
	@Select("SELECT CHNLNAMEPATH FROM t_channel WHERE CHANNELID=#{channelid}")
	String chnlnamepath(Integer channelid);
	
	/**
	 * 根据id删除频道
	 * 
	 * @return
	 */
	@Delete("DELETE FROM t_channel WHERE CHANNELID=#{channelid}")
	int delChannel(Integer channelid);

	/**
	 * 跟新频道信息
	 * 
	 * @param channel
	 * @return
	 */
	@Update("UPDATE t_channel SET CHANNELID=#{channelid},CHNLNAME=#{chnlname},CHNLDESC=#{chnldesc},CHNLNAMEPATH=#{chnlnamepath},PARENTID=#{parentid},CHNLORDER=#{chnlorder},CRTIME=#{crtime} WHERE CHANNELID=#{channelid}")
	int updChannel(Channel channel);

	/**
	 * 通过id查询频道
	 * 
	 * @return
	 */
	@Select("SELECT CHANNELID,CHNLNAME,CHNLDESC,CHNLNAMEPATH,PARENTID,CHNLORDER,CRTIME FROM t_channel WHERE CHANNELID=#{channelid}")
	Channel byIdChannel(Integer channelid);
	
	/**
	 * 查询父栏目
	 * @return
	 */
	@Select("SELECT CHANNELID,CHNLNAME,CHNLDESC,CHNLNAMEPATH,PARENTID,CHNLORDER,CRTIME FROM t_channel")
	List<Channel> queryClumn();
	
	/**
	 * 查询审核内容
	 * @param dtrs
	 * @return
	 *//*
	@Select("SELECT docid ,DOCTITLE,DOCHTMLCON,a.typeID,DOCRELTIME,\r\n" + 
			"u.`username`,b.typename ,h.CHNLNAME FROM T_document AS a LEFT JOIN t_doctype AS b ON a.typeid=b.typeid \r\n" + 
			"LEFT JOIN T_user AS u ON u.`USERID`=a.`USERID` \r\n" + 
			"LEFT JOIN t_channel AS h ON h.`CHANNELID`=a.`CHANNELID`limit(0,2)")
	@Results({ @Result(property="docid",column="docid",javaType=Integer.class),
		@Result(property="doctitle",column="DOCTITLE",javaType=String.class),
		@Result(property="dochtmlcon",column="DOCHTMLCON",javaType=String.class),
		@Result(property="Doctype.typeid",column="typeid",javaType=Integer.class),
		@Result(property="docreltime",column="DOCRELTIME",javaType=Date.class),
		@Result(property="user.username",column="username",javaType=String.class),
		@Result(property="doctype.typename",column="typename",javaType=String.class),
		@Result(property="channel.chnlname",column="chnlname",javaType=String.class),				
	})
	public List<Document> dtr() ;*/
	
	/**
	 * 查询待审核文章总数
	 * @return
	 */
	int unCheckSum(HashMap<String, Object> params);
	
	/**
	 * 查询待审核文章信息
	 * @return
	 */
	List<Document> queryUncheck(HashMap<String, Object> params);
	
	/**
	 * 跟新状态
	 * @return
	 */
	@Update("UPDATE t_document SET DOCSTATUS=#{status},CHECKTIME=#{checktime} WHERE DOCID=#{docid}")
	int updateStatus(@Param("docid")Integer docid,@Param("status") Integer status,@Param("checktime") Date checktime);
	
	
	/**
	 * 带条件查询已审核文章信息
	 * @param params
	 * @return
	 */
	List<Document> queryCheckYet(HashMap<String, Object> params);
	
	/**
	 * 带条件查询已审核文章总数
	 * @return
	 */
	int unCheckYetSum(HashMap<String, Object> params);
	
	
	/**
	 * 带条件查询已驳回文章信息
	 * @param params
	 * @return
	 */
	List<Document> queryCheckReject(HashMap<String, Object> params);
	
	/**
	 * 带条件查询已驳回文章总数
	 * @return
	 */
	int unCheckRejectSum(HashMap<String, Object> params);


}
