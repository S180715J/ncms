package com.newer.ncms.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 班级信息实体类
 * 
 * @author ZhangXin
 *
 */
public class Clazz implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer classid;// 班级id
	private String code;// 班级编号
	private Integer schoolarea;// 所属校区
	private Integer specialty;// 专业方向
	private Date begindate;// 开课日期
	private Date enddate;// 结课日期
	private Integer initcount;// 开班人数
	private Integer onlinecount;// 在读人数
	private Integer status;// 班级状态
	private Integer endcount;// 结课人数
	private Integer examcount;// 考试人数
	private String passcount;// 考试通过率
	private Integer jobcount;// 就业人数
	private Integer praisecount;// 口碑人数
	private Integer misscount;// 流失人数
	private Integer isdelete;// 是否已删除 0已删除 1未删除

	public Integer getClassid() {
		return classid;
	}

	public void setClassid(Integer classid) {
		this.classid = classid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getSchoolarea() {
		return schoolarea;
	}

	public void setSchoolarea(Integer schoolarea) {
		this.schoolarea = schoolarea;
	}

	public Integer getSpecialty() {
		return specialty;
	}

	public void setSpecialty(Integer specialty) {
		this.specialty = specialty;
	}

	public Date getBegindate() {
		return begindate;
	}

	public void setBegindate(Date begindate) {
		this.begindate = begindate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Integer getInitcount() {
		return initcount;
	}

	public void setInitcount(Integer initcount) {
		this.initcount = initcount;
	}

	public Integer getOnlinecount() {
		return onlinecount;
	}

	public void setOnlinecount(Integer onlinecount) {
		this.onlinecount = onlinecount;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getEndcount() {
		return endcount;
	}

	public void setEndcount(Integer endcount) {
		this.endcount = endcount;
	}

	public Integer getExamcount() {
		return examcount;
	}

	public void setExamcount(Integer examcount) {
		this.examcount = examcount;
	}

	public String getPasscount() {
		return passcount;
	}

	public void setPasscount(String passcount) {
		this.passcount = passcount;
	}

	public Integer getJobcount() {
		return jobcount;
	}

	public void setJobcount(Integer jobcount) {
		this.jobcount = jobcount;
	}

	public Integer getPraisecount() {
		return praisecount;
	}

	public void setPraisecount(Integer praisecount) {
		this.praisecount = praisecount;
	}

	public Integer getMisscount() {
		return misscount;
	}

	public void setMisscount(Integer misscount) {
		this.misscount = misscount;
	}

	public Integer getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Clazz [classid=" + classid + ", code=" + code + ", schoolarea=" + schoolarea + ", specialty="
				+ specialty + ", begindate=" + begindate + ", enddate=" + enddate + ", initcount=" + initcount
				+ ", onlinecount=" + onlinecount + ", status=" + status + ", endcount=" + endcount + ", examcount="
				+ examcount + ", passcount=" + passcount + ", jobcount=" + jobcount + ", praisecount=" + praisecount
				+ ", misscount=" + misscount + ", isdelete=" + isdelete + "]";
	}

}
