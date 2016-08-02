package cn.wlmb.css.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.wlmb.css.mapper.ServermsgMapper;
import cn.wlmb.css.po.Servermsg;
import cn.wlmb.css.po.ServermsgExample;
import cn.wlmb.css.service.ServermsgService;

public class ServermsgServiceImpl implements ServermsgService {

	@Autowired
	private ServermsgMapper servermsgMapper;
	
	@Override
	public List<Servermsg> findServermsgByExample(ServermsgExample example) {
		return servermsgMapper.selectByExample(example);
	}

}
