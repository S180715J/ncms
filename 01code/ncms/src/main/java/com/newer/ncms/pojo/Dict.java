package com.newer.ncms.pojo;

import java.io.Serializable;

/**
 * 数据字典实体类
 * @author ZhangXin
 *
 */
public class Dict implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String dicttype;//字典大类
	private String dictid;//字典小类
	private String dicname;//字典名称
	private Integer sortno;//排序号
	private String remark;//备注
	public String getDicttype() {
		return dicttype;
	}
	public void setDicttype(String dicttype) {
		this.dicttype = dicttype;
	}
	public String getDictid() {
		return dictid;
	}
	public void setDictid(String dictid) {
		this.dictid = dictid;
	}
	public String getDicname() {
		return dicname;
	}
	public void setDicname(String dicname) {
		this.dicname = dicname;
	}
	public Integer getSortno() {
		return sortno;
	}
	public void setSortno(Integer sortno) {
		this.sortno = sortno;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Dict [dicttype=" + dicttype + ", dictid=" + dictid + ", dicname=" + dicname + ", sortno=" + sortno
				+ ", remark=" + remark + "]";
	}

	
	
	

}
