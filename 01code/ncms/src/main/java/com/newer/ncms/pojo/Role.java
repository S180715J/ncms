package com.newer.ncms.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色实体类
 * @author ZhangXin
 *
 */
public class Role implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer roleid;//角色id
	private String rolename;//角色名称
	private String rolecode;//角色编码
	private String roledesc;//角色描述
	private Date crtime;//创建时间
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getRolecode() {
		return rolecode;
	}
	public void setRolecode(String rolecode) {
		this.rolecode = rolecode;
	}
	public String getRoledesc() {
		return roledesc;
	}
	public void setRoledesc(String roledesc) {
		this.roledesc = roledesc;
	}
	public Date getCrtime() {
		return crtime;
	}
	public void setCrtime(Date crtime) {
		this.crtime = crtime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Role [roleid=" + roleid + ", rolename=" + rolename + ", rolecode=" + rolecode + ", roledesc=" + roledesc
				+ ", crtime=" + crtime + "]";
	}
	


}
