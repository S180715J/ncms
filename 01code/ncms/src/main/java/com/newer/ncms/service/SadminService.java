package com.newer.ncms.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newer.ncms.mapper.SadminMapper;
import com.newer.ncms.model.Page;
import com.newer.ncms.pojo.Channel;
import com.newer.ncms.pojo.Dict;
import com.newer.ncms.pojo.Document;
import com.newer.ncms.pojo.Role;
import com.newer.ncms.pojo.User;

/**
 * 超级管理员模块业务逻辑层
 * 
 * @author ZhangXin
 *
 */
@Service(value = "sadminService")
public class SadminService {

	@Autowired
	private SadminMapper sadminMapper;

	/**
	 * 查询管理员信息
	 * 
	 * @return
	 */
	public List<Role> queryRole() {
		return sadminMapper.selectRole();
	}

	/**
	 * .返回所有管理员信息
	 * 
	 * @param curPage
	 * @param limit
	 * @return
	 */
	public Page<User> queryAdmin(String curPage, Integer limit) {
		HashMap<String, Object> params = new HashMap<>();
		// 获得总记录数
		int totalrows = sadminMapper.adminSum();
		if (totalrows != 0) {
			// 创建page对象
			Page<User> page = new Page<>(curPage, totalrows, limit);
			// 获得起始索引
			int index = (page.getCurPage() - 1) * limit;
			params.put("index", index);
			params.put("limit", limit);
			// 根据条件查询员工信息
			List<User> list = sadminMapper.selectAdmin(params);
			page.setList(list);
			return page;
		}
		return null;
	}

	/**
	 * .带条件查询管理员数据集合的page对象 
	 * 
	 * @return 根据查询的条件返回相应的page对象
	 */
	public Page<User> querySadmin(HashMap<String, Object> params, String curPage, Integer limit) {

		// 查询数据库中的总记录数
		int getTotalRecordNo = sadminMapper.getTotalSadmin(params);


		// 创建page对象
		Page<User> page = new Page<>(curPage, getTotalRecordNo, limit);

		// 先拿到修正后的pageNo
		int index = (page.getCurPage() - 1) * limit;
		params.put("index", index);
		params.put("limit", limit);
		// 查询数据库中的数据
		List<User> list = sadminMapper.querySadmin(params);
		// 将数据集合放入page中
		page.setList(list);

		return page;
	}
	
	
	/**
	 * .回显角色身份
	 * 
	 * @return
	 */
	public List<Role> queryIdentity() {
		return sadminMapper.selectIdentity();
	}
	
	
	/**
	 * 添加管理员
	 * 
	 * @param user
	 * @return
	 */
	public Integer addSadmin(User user) {
		return sadminMapper.addSadmin(user);

	}
	
	/**
	 * 检验用户名是否存在
	 * @param string
	 * @return
	 */
	public String check(String username) {
		return sadminMapper.check(username);
	}

	/**
	 * 删除管理员
	 * 
	 * @param userid
	 * @return
	 */
	public int delSdmin(Integer userid) {
		return sadminMapper.delSadmin(userid);
	}

	/**
	 * 修改教师
	 * 
	 * @param user
	 * @return
	 */
	public int upSadmin(User user) {
		return sadminMapper.upSadmin(user);
	}

	/**
	 * 根据id修改回显教师信息
	 * 
	 * @param userid
	 * @return
	 */
	public User showSadmin(Integer userid) {
		return sadminMapper.showSadmin(userid);
	}

	
	

	/**
	 * 查询所有频道信息
	 * 
	 * @param curPage
	 * @param limit
	 * @return
	 */
	public Page<Channel> channels(String curPage, Integer limit) {
		HashMap<String, Object> params = new HashMap<>();
		// 获得总记录数
		int totalrows = sadminMapper.channelsSum();
		if (totalrows != 0) {
			// 创建page对象
			Page<Channel> page = new Page<>(curPage, totalrows, limit);
			// 获得起始索引
			int index = (page.getCurPage() - 1) * limit;
			params.put("index", index);
			params.put("limit", limit);
			// 根据条件查询员工信息
			List<Channel> list = sadminMapper.channels(params);
			page.setList(list);
			return page;
		}
		return null;
	}

	/**
	 * 添加频道信息
	 * 
	 * @param channel
	 * @return
	 */
	public int addChannel(Channel channel) {
		return sadminMapper.addChannel(channel);
	}
	
	/**
	 * 查询父路径
	 * @param channelid
	 * @return
	 */
	public String chnlnamepath(Integer channelid) {
		return sadminMapper.chnlnamepath(channelid);
	}

	/**
	 * 根据id删除频道
	 * 
	 * @param channelid
	 * @return
	 */
	public int delChannel(Integer channelid) {
		return sadminMapper.delChannel(channelid);
	}

	/**
	 * 跟新频道信息
	 * 
	 * @param channel
	 * @return
	 */
	public int updChannel(Channel channel) {
		return sadminMapper.updChannel(channel);
	}

	/**
	 * 通过id查询频道
	 * 
	 * @param channelid
	 * @return
	 */
	public Channel byIdChannel(Integer channelid) {
		return sadminMapper.byIdChannel(channelid);
	}

	/**
	 * 查询父栏目
	 * @return
	 */
	public List<Channel> queryClumn() {
		return  sadminMapper.queryClumn();
	}
	
	
	/**
	 * .带条件查询待审核文章数据集合的page对象 
	 * 
	 * @return 根据查询的条件返回相应的page对象
	 */
	public Page<Document> queryUncheck(HashMap<String, Object> params, String curPage, Integer limit) {

		// 查询数据库中的总记录数
		int unCheckSum = sadminMapper.unCheckSum(params);
		System.out.println(unCheckSum);

		// 创建page对象
		Page<Document> page = new Page<>(curPage, unCheckSum, limit);

		// 先拿到修正后的pageNo
		int index = (page.getCurPage() - 1) * limit;
		params.put("index", index);
		params.put("limit", limit);
		// 查询数据库中的数据
		List<Document> list = sadminMapper.queryUncheck(params);
		// 将数据集合放入page中
		page.setList(list);

		return page;
	}
	
	/**
	 * 跟新文章状态
	 * @param docid
	 * @return
	 */
	public int updateStatus(Integer docid,Integer status,Date checktime) {
		return sadminMapper.updateStatus(docid,status,checktime);
	}
	
	/**
	 * .带条件查询已审核文章数据的page对象 
	 * 
	 * @return 根据查询的条件返回相应的page对象
	 */
	public Page<Document> queryCheckYet(HashMap<String, Object> params, String curPage, Integer limit) {

		// 查询数据库中的总记录数
		int unCheckYetSum = sadminMapper.unCheckYetSum(params);


		// 创建page对象
		Page<Document> page = new Page<>(curPage, unCheckYetSum, limit);

		// 先拿到修正后的pageNo
		int index = (page.getCurPage() - 1) * limit;
		params.put("index", index);
		params.put("limit", limit);
		// 查询数据库中的数据
		List<Document> list = sadminMapper.queryCheckYet(params);
		// 将数据集合放入page中
		page.setList(list);

		return page;
	}
	
	/**
	 * .带条件查询已驳回文章数据的page对象 
	 * 
	 * @return 根据查询的条件返回相应的page对象
	 */
	public Page<Document> queryCheckReject(HashMap<String, Object> params, String curPage, Integer limit) {

		// 查询数据库中的总记录数
		int unCheckRejectSum = sadminMapper.unCheckRejectSum(params);


		// 创建page对象
		Page<Document> page = new Page<>(curPage,unCheckRejectSum, limit);

		// 先拿到修正后的pageNo
		int index = (page.getCurPage() - 1) * limit;
		params.put("index", index);
		params.put("limit", limit);
		// 查询数据库中的数据
		List<Document> list = sadminMapper.queryCheckReject(params);
		// 将数据集合放入page中
		page.setList(list);

		return page;
	}

	
	

}
