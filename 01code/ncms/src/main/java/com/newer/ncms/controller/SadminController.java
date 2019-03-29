package com.newer.ncms.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newer.ncms.model.Page;
import com.newer.ncms.pojo.Channel;
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
	@RequestMapping(value = "/queryAdmin", method = RequestMethod.GET)
	public ResponseEntity<?> queryAdmin(@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "limit", required = false, defaultValue = "6") Integer limit) {
		Page<User> data = sadminService.queryAdmin(page, limit);
		ResponseEntity<?> entity = null;
		if (data != null) {
			entity = new ResponseEntity<>(data, HttpStatus.OK);
		}
		return entity;
	}
	
	/**
	 * 带条件返回所有管理员信息
	 * 
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/querySadmin", method = RequestMethod.GET)
	public ResponseEntity<?> querySadmin(
			@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "limit", required = false, defaultValue = "6") Integer limit, User user) {
		HashMap<String, Object> params = new HashMap<>();
		if (user.getUsername() != null) {
			params.put("username", user.getUsername());
		}

		if (user.getDept() != null) {
			params.put("dept", user.getDept().getDictid());
		}
		Page<User> data = sadminService.querySadmin(params, page, limit);
		
		ResponseEntity<?> entity = null;
		if (data != null) {
			entity = new ResponseEntity<>(data, HttpStatus.OK);
		}
		return entity;

	}
	
	
	/**
	 * 添加管理员
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/addSadmin", method = RequestMethod.POST)
	public String addSadmin(User user) {
		int i = sadminService.addSadmin(user);
		if (i > 0 ) {
			return "ok";

		}
		return null;
	}
	
	/**
	 * 验证用户名
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public String check(User user) {
		System.out.println(user.getUsername());
		String check = sadminService.check(user.getUsername());
		System.out.println(check);
		if (check==null) {
			return "ok";

		}
		return null;
	}
	
	
	/**
	 * 删除管理员
	 * @param userid
	 * @return
	 */
	@RequestMapping(value = "/delSadmin", method = RequestMethod.DELETE)
	public String delSadmin(String userid) {
		String id[] = userid.split(",");
		int[] arr = new int[id.length];
		for (int i = 0; i < id.length; i++) {
			arr[i] = Integer.parseInt(id[i]);
			int delStudent =sadminService.delSdmin(arr[i]);
			if (delStudent <= 0) {
				return "fail";
			}
		}

		return "ok";

	}
	
	/**
	 * 修改教师
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/upSadmin", method = RequestMethod.PUT)
	public String upSadmin(User user) {
		int upSadmin = sadminService.upSadmin(user);
		if (upSadmin > 0) {
			return "ok";
		} else {
			return "fail";
		}
	}
	
	/**
	 * 修改教师回显数据
	 * @param userid
	 * @return
	 */
	@RequestMapping(value = "/showSadmin/{userid}", method = RequestMethod.GET)
	public ResponseEntity<?> showSadmin(@PathVariable("userid")Integer userid) {
		User showTeacher = sadminService.showSadmin(userid);
		if (showTeacher != null) {
			return new ResponseEntity<>(showTeacher, HttpStatus.OK);
		}
		return null;

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
		String chnlnamepath = sadminService.chnlnamepath(channel.getParentid());
		
		channel.setChnlnamepath(chnlnamepath+"/"+channel.getChnlname());
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
	@Transactional
	@RequestMapping(value = "/delChannel", method = RequestMethod.DELETE)
	public String delChannel(String ids) {
		String id[] = ids.split(",");
		int[] arr = new int[id.length];
		for (int i = 0; i < id.length; i++) {
			arr[i] = Integer.parseInt(id[i]);
			int delChannel = sadminService.delChannel(arr[i]);
			if (delChannel <= 0) {
				return "fail";
			}
		}
		return "ok";
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
	 * 带条件返回所有待审核信息
	 * 
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/queryUncheck", method = RequestMethod.GET)
	public ResponseEntity<?> queryUncheck(
			@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "limit", required = false, defaultValue = "6") Integer limit, Document document) {
		HashMap<String, Object> params = new HashMap<>();
		if (document.getDoctitle() != null) {
			params.put("doctitle", document.getDoctitle());
		}

		if (document.getDocchannel() != null) {
			params.put("chnlname", document.getDocchannel().getChnlname());
			params.put("chnlnamepath", document.getDocchannel().getChnlnamepath());

		}
		Page<Document> data = sadminService.queryUncheck(params, page, limit);
		ResponseEntity<?> entity = null;
		if (data != null) {
			entity = new ResponseEntity<>(data, HttpStatus.OK);
		}
		return entity;

	}
	
	/**
	 * 审核同意
	 * 
	 * @param stuid
	 * @return
	 */
	@Transactional
	@RequestMapping(value = "/pass", method = RequestMethod.PUT)
	public String pass(String ids) {
		Date date=new Date();
		String id[] = ids.split(",");
		int[] arr = new int[id.length];
		for (int i = 0; i < id.length; i++) {
			arr[i] = Integer.parseInt(id[i]);
			int delStudent = sadminService.updateStatus(arr[i],2,date);
			if (delStudent <= 0) {
				return "fail";
			}
		}

		return "ok";

	}
	
	
	/**
	 * 驳回
	 * 
	 * @param stuid
	 * @return
	 */
	@Transactional
	@RequestMapping(value = "/reject", method = RequestMethod.PUT)
	public String reject(String ids) {
		Date date=new Date();
		String id[] = ids.split(",");
		int[] arr = new int[id.length];
		for (int i = 0; i < id.length; i++) {
			arr[i] = Integer.parseInt(id[i]);
			int delStudent = sadminService.updateStatus(arr[i],3,date);
			if (delStudent <= 0) {
				return "fail";
			}
		}

		return "ok";

	}
	
	

	/**
	 * 带条件返回已审核信息
	 * 
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/queryCheckYet", method = RequestMethod.GET)
	public ResponseEntity<?> queryCheckYet(
			@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "limit", required = false, defaultValue = "6") Integer limit, Document document) {
		HashMap<String, Object> params = new HashMap<>();
		if (document.getDoctitle() != null) {
			params.put("doctitle", document.getDoctitle());
		}
		if (document.getDoctype() != null) {
			params.put("chnlname", document.getDoctype().getDicname());
		}
		if (document.getDocchannel() != null) {
			params.put("chnlnamepath", document.getDocchannel().getChnlnamepath());
		}
		Page<Document> data = sadminService.queryCheckYet(params, page, limit);
		
		ResponseEntity<?> entity = null;
		if (data != null) {
			entity = new ResponseEntity<>(data, HttpStatus.OK);
		}
		return entity;

	}
	
	
	/**
	 * 带条件返回已驳回信息
	 * 
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/queryCheckReject", method = RequestMethod.GET)
	public ResponseEntity<?> queryCheckReject(
			@RequestParam(value = "page", required = false, defaultValue = "1") String page,
			@RequestParam(value = "limit", required = false, defaultValue = "6") Integer limit, Document document) {
		HashMap<String, Object> params = new HashMap<>();
		if (document.getDoctitle() != null) {
			params.put("doctitle", document.getDoctitle());
		}

		if (document.getDoctype() != null) {
			params.put("chnlname", document.getDoctype().getDicname());
		}
		if (document.getDocchannel() != null) {
			params.put("chnlnamepath", document.getDocchannel().getChnlnamepath());
		}
		Page<Document> data = sadminService.queryCheckReject(params, page, limit);
		
		ResponseEntity<?> entity = null;
		if (data != null) {
			entity = new ResponseEntity<>(data, HttpStatus.OK);
		}
		return entity;

	}
	

	
	

}
