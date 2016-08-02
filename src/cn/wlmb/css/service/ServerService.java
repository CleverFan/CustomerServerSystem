package cn.wlmb.css.service;

import java.util.List;

import cn.wlmb.css.po.Server;
import cn.wlmb.css.po.ServerExample;

public interface ServerService {
	
	/**
	 * 查找在线客服列表
	 * @param example 一个ServerExample对象
	 * @return
	 */
	List<Server> findServerList(ServerExample example);
	
	/**
	 * 根据id查找客服
	 * @param id server的id
	 * @return 一个server对象
	 */
	Server findServerById(String id);
	
	/**
	 * 在数据库中添加一个客服
	 * @param server 一个server对象
	 */
	int insertServer(Server server);
	

	/**
	 * 是否某客服已经存在
	 * @param object
	 * @return 是否存在
	 */
	boolean isExistServer(Object object);
	
	/**
	 * 根据id 修改server
	 * @param server 修改后的server
	 * @return
	 */
	int updateServerById(Server server);
}
