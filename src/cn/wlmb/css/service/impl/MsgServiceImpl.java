package cn.wlmb.css.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.wlmb.css.mapper.MsgMapper;
import cn.wlmb.css.po.Msg;
import cn.wlmb.css.po.MsgExample;
import cn.wlmb.css.service.MsgService;


public class MsgServiceImpl implements MsgService{

	@Autowired
	private MsgMapper msgMapper;

	@Override
	public int insertMsg(Msg msg) {
		return msgMapper.insert(msg);
	}

	@Override
	public List<Msg> findMsgByExample(MsgExample example) {
		
		return msgMapper.selectByExample(example);
	}
	



}
