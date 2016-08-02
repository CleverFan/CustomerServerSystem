package cn.wlmb.css.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.wlmb.css.mapper.ChatMapper;
import cn.wlmb.css.po.Chat;
import cn.wlmb.css.po.ChatExample;
import cn.wlmb.css.service.ChatService;

public class ChatServiceImpl implements ChatService {

	@Autowired
	private ChatMapper chatMapper;
	
	@Override
	public int insertChat(Chat chat) {		
		return chatMapper.insert(chat);
	}

	@Override
	public Chat findChatById(String id) {
		return chatMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Chat> findChatList(ChatExample example) {	
		return chatMapper.selectByExample(example);
	}

	@Override
	public List<Chat> findChatByExample(ChatExample example) {
		
		return chatMapper.selectByExample(example);
	}

	@Override
	public int updateChatById(Chat chat) {
		return chatMapper.updateByPrimaryKey(chat);
	}

}
