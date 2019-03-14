package com.newer.ncms.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 后台用户信息实体类
 * 
 * @author ZhangXin
 *
 */
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer userid;// 用户编号
	private String username;// 用户登录名
	private String realname;// 用户真实姓名
	private String nickname;// 昵称
	private String password;// 密码
	private Date crtime;// 创建时间
	private Integer isdelete;// 是否已删除
	private Integer sex;// 性别 0为男 1为女
	private String phone;// 联系方式
	private String email;// 邮箱
	private Role role;//角色类

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCrtime() {
		return crtime;
	}

	public void setCrtime(Date crtime) {
		this.crtime = crtime;
	}

	public Integer getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", realname=" + realname + ", nickname=" + nickname
				+ ", password=" + password + ", crtime=" + crtime + ", isdelete=" + isdelete + ", sex=" + sex
				+ ", phone=" + phone + ", email=" + email + ", role=" + role + "]";
	}

}
