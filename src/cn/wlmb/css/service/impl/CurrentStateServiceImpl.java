package cn.wlmb.css.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.wlmb.css.mapper.CurrentstateMapper;
import cn.wlmb.css.po.Currentstate;
import cn.wlmb.css.po.CurrentstateExample;
import cn.wlmb.css.service.CurrentStateService;

public class CurrentStateServiceImpl implements CurrentStateService {

	@Autowired
	private CurrentstateMapper currentstateMapper;
	
	@Override
	public List<Currentstate> findCurrentstateByExample(
			CurrentstateExample example) {
		return currentstateMapper.selectByExample(example);
	}

}
