package com.newer.ncms.pojo;

import java.io.Serializable;

/**
 * 学生信息实体类
 * 
 * @author ZhangXin
 *
 */
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer stuid;// 编号
	private String stucode;// 学号
	private String password;// 密码
	private String name;// 学生姓名
	private String pinying;// 姓名拼音
	private Dict sex;// 性别
	private Clazz clazz;// 班级
	private Dict specialty;// 专业方向
	private Dict schoolarea;// 校区
	private String nation;// 民族
	private String idcard;// 身份证号码
	private Dict edu;// 文化程度
	private String endschool;// 毕业学校
	private String contact;// 本人联系方式
	private String homecontact;// 家庭联系方式
	private String homeaddress;// 家庭住址
	private String postcode;// 邮编
	private String qq;// qq
	private Dict isdebt;// 是否欠费
	private String jobcity;// 就业城市
	private String jobcompany;// 就业企业
	private Double jobsal;// 就业薪资
	private String job;// 就业岗位
	private String remark;// 备注
	private Dict isdelete;// 是否已删除

	public Integer getStuid() {
		return stuid;
	}

	public void setStuid(Integer stuid) {
		this.stuid = stuid;
	}

	public String getStucode() {
		return stucode;
	}

	public void setStucode(String stucode) {
		this.stucode = stucode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPinying() {
		return pinying;
	}

	public void setPinying(String pinying) {
		this.pinying = pinying;
	}

	public Dict getSex() {
		return sex;
	}

	public void setSex(Dict sex) {
		this.sex = sex;
	}

	public Clazz getClazz() {
		return clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}

	public Dict getSpecialty() {
		return specialty;
	}

	public void setSpecialty(Dict specialty) {
		this.specialty = specialty;
	}

	

	public Dict getSchoolarea() {
		return schoolarea;
	}

	public void setSchoolarea(Dict schoolarea) {
		this.schoolarea = schoolarea;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public Dict getEdu() {
		return edu;
	}

	public void setEdu(Dict edu) {
		this.edu = edu;
	}

	

	public String getEndschool() {
		return endschool;
	}

	public void setEndschool(String endschool) {
		this.endschool = endschool;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getHomecontact() {
		return homecontact;
	}

	public void setHomecontact(String homecontact) {
		this.homecontact = homecontact;
	}

	public String getHomeaddress() {
		return homeaddress;
	}

	public void setHomeaddress(String homeaddress) {
		this.homeaddress = homeaddress;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public Dict getIsdebt() {
		return isdebt;
	}

	public void setIsdebt(Dict isdebt) {
		this.isdebt = isdebt;
	}

	public String getJobcity() {
		return jobcity;
	}

	public void setJobcity(String jobcity) {
		this.jobcity = jobcity;
	}

	public String getJobcompany() {
		return jobcompany;
	}

	public void setJobcompany(String jobcompany) {
		this.jobcompany = jobcompany;
	}

	public Double getJobsal() {
		return jobsal;
	}

	public void setJobsal(Double jobsal) {
		this.jobsal = jobsal;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	

	public Dict getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Dict isdelete) {
		this.isdelete = isdelete;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Student [stuid=" + stuid + ", stucode=" + stucode + ", password=" + password + ", name=" + name
				+ ", pinying=" + pinying + ", sex=" + sex + ", clazz=" + clazz + ", specialty=" + specialty
				+ ", schoolarea=" + schoolarea + ", nation=" + nation + ", idcard=" + idcard + ", edu=" + edu
				+ ", endshool=" + endschool + ", contact=" + contact + ", homecontact=" + homecontact + ", homeaddress="
				+ homeaddress + ", postcode=" + postcode + ", qq=" + qq + ", isdebt=" + isdebt + ", jobcity=" + jobcity
				+ ", jobcompany=" + jobcompany + ", jobsal=" + jobsal + ", job=" + job + ", remark=" + remark
				+ ", isdelete=" + isdelete + "]";
	}

}
