package com.newer.ncms.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newer.ncms.model.Page;
import com.newer.ncms.pojo.Channel;
import com.newer.ncms.pojo.Clazz;
import com.newer.ncms.pojo.Document;
import com.newer.ncms.pojo.Role;
import com.newer.ncms.pojo.User;
import com.newer.ncms.service.SadminService;
/**
 * 超级管理员模块控制层
 * @author ZhangXin
 *
 */
@RestController
public class SadminController {
	Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "sadminService")
	private SadminService sadminService;

	/**
	 * .返回所有角色信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/roleList", method = RequestMethod.GET)
	public ResponseEntity<?> queryRole() {
		log.info("开始检索所有管理员信息......");
		List<Role> role = sadminService.queryRole();
		if (role == null || role.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(role, HttpStatus.OK);
		}
	}

	/**
	 * .返回所有管理员信息
	 * 
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/userlist", method = RequestMethod.GET)
	public ResponseEntity<?> queryAdmin(@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "limit", required = false, defaultValue = "3") Integer limit) {
		Page<User> data = sadminService.queryAdmin(page, limit);
		ResponseEntity<?> entity = null;
		if (data != null) {
			entity = new ResponseEntity<>(data, HttpStatus.OK);
		}
		return entity;
	}

	/**
	 * .角色身份下拉框
	 * 
	 * @return
	 */
	@RequestMapping(value = "/identity", method = RequestMethod.GET)
	public ResponseEntity<?> queryIdentity() {
		List<Role> role = sadminService.queryIdentity();
		return new ResponseEntity<>(role, HttpStatus.OK);
	}
	
	
	/**
	 * 查询频道信息
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping(value="/channel",method=RequestMethod.GET)
	public  ResponseEntity<?> channels(@RequestParam(value="page",required=false,defaultValue="1")String page,
			@RequestParam(value="limit",required=false,defaultValue="3")Integer limit){
		     Page<Channel> channels = sadminService.channels(page, limit);
		     ResponseEntity<?> entity = null;
		     if(channels != null) {
		    	 entity = new ResponseEntity<>(channels,HttpStatus.OK);
		    	 
		     }
		     return entity;
	}
	
	
	/**
	 * 添加频道
	 * @param channel
	 * @return
	 */
	@RequestMapping(value="/addChannel",method=RequestMethod.POST)
	public String addChannel(Channel channel) {
		int addChannel = sadminService.addChannel(channel);
		if(addChannel > 0 ) {
			return "ok";
		}
		return  null;
	}
	
	
	/**
	 * 删除频道
	 * @param channelid
	 * @return
	 */
	@RequestMapping(value="/delChannel",method=RequestMethod.DELETE)
	public ResponseEntity<?> delChannel(@PathVariable("channelid") Integer channelid){
		if(channelid == null) {
			return new ResponseEntity<>("NOT FOUND:"+channelid,HttpStatus.NO_CONTENT); 
		}else {
			int delChannel = sadminService.delChannel(channelid);
			return new ResponseEntity<>(channelid>0?"ok":"nodata",HttpStatus.OK);
		}
	}
	
	/**
	 * 修改频道
	 * @param channel
	 * @return
	 */
	@RequestMapping(value = "/updChannel", method = RequestMethod.PUT)
	public String updChannel(Channel channel) {
	 int updChannel = sadminService.updChannel(channel);
		if (updChannel > 0) {
			return "ok";
		} else {
			return "fail";
		}
	}
	
	/**
	 * 根据id回显
	 * @param channelid
	 * @return
	 */
	@RequestMapping(value = "/byIdChannel/{channelid}", method = RequestMethod.GET)
	public ResponseEntity<?> byIdChannel(@PathVariable("channelid")Integer channelid) {
		Channel byIdChannel = sadminService.byIdChannel(channelid);
		if (byIdChannel != null) {
			return new ResponseEntity<>(byIdChannel, HttpStatus.OK);
		}
		return null;

	}
	
	/**
	 * 查询父栏目
	 * @return
	 */
	@RequestMapping(value = "/queryClumn", method = RequestMethod.GET)
	public ResponseEntity<?> queryDocument() {
		List<Channel> queryDocument = sadminService.queryClumn();
		return new ResponseEntity<>(queryDocument, HttpStatus.OK);
	}
	

	/**
	 * 返回审核内容
	 * @return
	 */
	@RequestMapping(value = "queryDtrs", method = RequestMethod.GET)
	public ResponseEntity<?> queryDtrs(){
		List<Document> dtr = sadminService.dtr();
		if(dtr!=null) {
			return new ResponseEntity<>(dtr,HttpStatus.OK);
		}
		return null;
		
	}
	
	

}
