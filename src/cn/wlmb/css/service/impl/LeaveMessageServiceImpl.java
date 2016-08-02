package cn.wlmb.css.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.wlmb.css.mapper.LeavemessageMapper;
import cn.wlmb.css.po.Leavemessage;
import cn.wlmb.css.po.LeavemessageExample;
import cn.wlmb.css.service.LeaveMessageService;

public class LeaveMessageServiceImpl implements LeaveMessageService{

	@Autowired
	LeavemessageMapper leavemessageMapper;
	
	@Override
	public List<Leavemessage> findLeaveMsgList(LeavemessageExample example) {
		
		return leavemessageMapper.selectByExample(example);
	}
	
}
