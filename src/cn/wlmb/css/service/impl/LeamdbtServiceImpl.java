package cn.wlmb.css.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.wlmb.css.mapper.LeavemsgdividebytimeMapper;
import cn.wlmb.css.po.Leavemsgdividebytime;
import cn.wlmb.css.po.LeavemsgdividebytimeExample;
import cn.wlmb.css.service.LeamdbtService;

public class LeamdbtServiceImpl implements LeamdbtService {

	@Autowired
	private LeavemsgdividebytimeMapper leavemsgdividebytimeMapper;
	
	@Override
	public List<Leavemsgdividebytime> findLeadbt(
			LeavemsgdividebytimeExample example) {
		return leavemsgdividebytimeMapper.selectByExample(example);
	}

}
