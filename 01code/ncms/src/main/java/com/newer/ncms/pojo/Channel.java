package com.newer.ncms.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 频道实体类
 * 
 * @author ZhangXin
 *
 */
public class Channel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer channelid;// 频道编号
	private String chnlname;// 频道名称（唯一标识）
	private String chnldesc;// 描述
	private String chanlnamepath;// 栏目路径
	private Integer parentid;// 父栏目编号
	private Integer chnlorder;// 排序号
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date crtime;// 创建时间

	public Integer getChannelid() {
		return channelid;
	}

	public void setChannelid(Integer channelid) {
		this.channelid = channelid;
	}

	public String getChnlname() {
		return chnlname;
	}

	public void setChnlname(String chnlname) {
		this.chnlname = chnlname;
	}

	public String getChnldesc() {
		return chnldesc;
	}

	public void setChnldesc(String chnldesc) {
		this.chnldesc = chnldesc;
	}

	public String getChanlnamepath() {
		return chanlnamepath;
	}

	public void setChanlnamepath(String chanlnamepath) {
		this.chanlnamepath = chanlnamepath;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public Integer getChnlorder() {
		return chnlorder;
	}

	public void setChnlorder(Integer chnlorder) {
		this.chnlorder = chnlorder;
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
		return "Channel [channelid=" + channelid + ", chnlname=" + chnlname + ", chnldesc=" + chnldesc
				+ ", chanlnamepath=" + chanlnamepath + ", parentid=" + parentid + ", chnlorder=" + chnlorder
				+ ", crtime=" + crtime + "]";
	}

}
