package com.newer.ncms.pojo;

import java.io.Serializable;
import java.util.Date;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

/**
 * 文档信息实体类
 * 
 * @author ZhangXin
 *
 */
public class Document implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer docid;// 文档编号
	private Integer docchannel;// 所属栏目
	private String doctitle;// 文档标题
	private String docsubtitle;// 文档副标题
	private String docabstract;// 内容摘要
	private String docimage;// 微缩图片
	private Integer istop;// 是否置顶 1是 0否
	private Integer ishighlight;// 是否加精 1是 0否
	private String docauthor; // 作者
	private Date docvalid;// 生效时间
	private Date docunvalid;// 失效时间
	private String docsource;// 文档来源
	private String url;// 外部链接地址
	private String dochtmlcon;// 文章内容
	private Date docreltime;// 撰写时间
	private User user;// 文档创建人
	private Integer docstatus;// 文档状态
	private Integer isdelete;// 是否已删除
	private Doctype doctype;// 发布类型

	public Integer getDocid() {
		return docid;
	}

	public void setDocid(Integer docid) {
		this.docid = docid;
	}

	public Integer getDocchannel() {
		return docchannel;
	}

	public void setDocchannel(Integer docchannel) {
		this.docchannel = docchannel;
	}

	public String getDoctitle() {
		return doctitle;
	}

	public void setDoctitle(String doctitle) {
		this.doctitle = doctitle;
	}

	public String getDocsubtitle() {
		return docsubtitle;
	}

	public void setDocsubtitle(String docsubtitle) {
		this.docsubtitle = docsubtitle;
	}

	public String getDocabstract() {
		return docabstract;
	}

	public void setDocabstract(String docabstract) {
		this.docabstract = docabstract;
	}

	public String getDocimage() {
		return docimage;
	}

	public void setDocimage(String docimage) {
		this.docimage = docimage;
	}

	public Integer getIstop() {
		return istop;
	}

	public void setIstop(Integer istop) {
		this.istop = istop;
	}

	public Integer getIshighlight() {
		return ishighlight;
	}

	public void setIshighlight(Integer ishighlight) {
		this.ishighlight = ishighlight;
	}

	public String getDocauthor() {
		return docauthor;
	}

	public void setDocauthor(String docauthor) {
		this.docauthor = docauthor;
	}

	public Date getDocvalid() {
		return docvalid;
	}

	public void setDocvalid(Date docvalid) {
		this.docvalid = docvalid;
	}

	public Date getDocunvalid() {
		return docunvalid;
	}

	public void setDocunvalid(Date docunvalid) {
		this.docunvalid = docunvalid;
	}

	public String getDocsource() {
		return docsource;
	}

	public void setDocsource(String docsource) {
		this.docsource = docsource;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDochtmlcon() {
		return dochtmlcon;
	}

	public void setDochtmlcon(String dochtmlcon) {
		this.dochtmlcon = dochtmlcon;
	}

	public Date getDocreltime() {
		return docreltime;
	}

	public void setDocreltime(Date docreltime) {
		this.docreltime = docreltime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getDocstatus() {
		return docstatus;
	}

	public void setDocstatus(Integer docstatus) {
		this.docstatus = docstatus;
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

	public Doctype getDoctype() {
		return doctype;
	}

	public void setDoctype(Doctype doctype) {
		this.doctype = doctype;
	}

	@Override
	public String toString() {
		return "Document [docid=" + docid + ", docchannel=" + docchannel + ", doctitle=" + doctitle + ", docsubtitle="
				+ docsubtitle + ", docabstract=" + docabstract + ", docimage=" + docimage + ", istop=" + istop
				+ ", ishighlight=" + ishighlight + ", docauthor=" + docauthor + ", docvalid=" + docvalid
				+ ", docunvalid=" + docunvalid + ", docsource=" + docsource + ", url=" + url + ", dochtmlcon="
				+ dochtmlcon + ", docreltime=" + docreltime + ", user=" + user + ", docstatus=" + docstatus
				+ ", isdelete=" + isdelete + ", doctype=" + doctype + "]";
	}

}
