package cn.wlmb.css.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.wlmb.css.mapper.SystemansMapper;
import cn.wlmb.css.po.Systemans;
import cn.wlmb.css.po.SystemansExample;
import cn.wlmb.css.service.SystemanService;

public class SystemanServiceImpl implements SystemanService {

	@Autowired
	private SystemansMapper systemansMapper;
	
	
	@Override
	public int insertContent(Systemans systemans) {
		return systemansMapper.insert(systemans);
	}

	@Override
	public List<Systemans> findMsgByExample(SystemansExample example) {
		return systemansMapper.selectByExample(example);
	}

}
