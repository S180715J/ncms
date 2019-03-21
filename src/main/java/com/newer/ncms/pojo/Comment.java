package com.newer.ncms.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 评论实体类
 * 
 * @author ZhangXin
 *
 */

public class Comment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer commentid;// 评论id
	private String commentcontent;// 评论内容
	private Integer parentid;// 父评论id
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date crtime;// 评论时间
	private User user;// 评论人
	private Document subjectid;// 评论所属主题
	private String isnewquest;// 是否属于新发起问题下的评论

	public Integer getCommentid() {
		return commentid;
	}

	public void setCommentid(Integer commentid) {
		this.commentid = commentid;
	}

	public String getCommentcontent() {
		return commentcontent;
	}

	public void setCommentcontent(String commentcontent) {
		this.commentcontent = commentcontent;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public Date getCrtime() {
		return crtime;
	}

	public void setCrtime(Date crtime) {
		this.crtime = crtime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Document getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(Document subjectid) {
		this.subjectid = subjectid;
	}

	public String getIsnewquest() {
		return isnewquest;
	}

	public void setIsnewquest(String isnewquest) {
		this.isnewquest = isnewquest;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Comment [commentid=" + commentid + ", commentcontent=" + commentcontent + ", parentid=" + parentid
				+ ", crtime=" + crtime + ", user=" + user + ", subjectid=" + subjectid + ", isnewquest=" + isnewquest
				+ "]";
	}

}
