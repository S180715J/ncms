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

import com.newer.ncms.pojo.Channel;
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
	 * .返回所有管理员信息
	 * 
	 * @return
	 */
	@Select("SELECT a.`USERID`,a.`USERNAME`,a.`REALNAME`,r.`ROLENAME`,a.`CRTIME`,d.`DICNAME` FROM `t_user` a,`t_role` r,`t_dict` d \r\n"
			+ "WHERE a.`ROLEID`=r.`ROLEID` AND a.`ISDELETE`=d.`DICTID` AND d.`DICTTYPE`='isdelete' GROUP BY a.`USERID` LIMIT #{index},#{limit}")
	@Results({ @Result(property = "userid", column = "userid", javaType = Integer.class),
			@Result(property = "username", column = "username", javaType = String.class),
			@Result(property = "realname", column = "realname", javaType = String.class),
			@Result(property = "role.rolename", column = "rolename", javaType = String.class),
			@Result(property = "crtime", column = "crtime", javaType = Date.class),
			@Result(property = "isdelete.dicname", column = "dicname", javaType = String.class) })
	public List<User> selectAdmin(HashMap<String, Object> params);

	/**
	 * .获得用户的总记录数
	 * 
	 * @return
	 */
	@Select("SELECT COUNT(*) FROM t_user")
	public int adminSum();

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
	 * y 查询审核内容
	 * @param dtrs
	 * @return
	 */
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
	public List<Document> dtr() ;

}
