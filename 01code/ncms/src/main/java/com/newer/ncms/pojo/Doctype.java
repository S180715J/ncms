package com.newer.ncms.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 文档分类实体类
 * 
 * @author ZhangXin
 *
 */
public class Doctype implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer typeid;// 分类编号
	private String typename;// 分类名称
	private Date crtime;// 创建时间
	private Integer sortnum;// 排序号

	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public Date getCrtime() {
		return crtime;
	}

	public void setCrtime(Date crtime) {
		this.crtime = crtime;
	}

	public Integer getSortnum() {
		return sortnum;
	}

	public void setSortnum(Integer sortnum) {
		this.sortnum = sortnum;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Doctype [typeid=" + typeid + ", typename=" + typename + ", crtime=" + crtime + ", sortnum=" + sortnum
				+ "]";
	}

}
