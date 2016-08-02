package cn.wlmb.css.service;

import java.util.List;

import cn.wlmb.css.po.Chat;
import cn.wlmb.css.po.ChatExample;

public interface ChatService {
	
	/**
	 * 添加一个新的chat
	 * 
	 */
	int insertChat(Chat chat);
	
	/**
	 * 根据主键查询chat
	 * @param object
	 * @return 查出的chat
	 *
	 */
	Chat findChatById(String id);
	
	/**
	 * 根据需要查询聊天记录的列表
	 * @param example
	 * @return  一个聊天记录的list
	 * 
	 */
	List<Chat> findChatList(ChatExample example);
	
	/**
	 * @param example
	 * @return
	 */
	List<Chat> findChatByExample(ChatExample example);
	
	/**
	 * 更新chat
	 * @param chat
	 * @return
	 */
	int updateChatById(Chat chat);
}
