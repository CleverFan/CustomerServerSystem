package cn.wlmb.css.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.wlmb.css.mapper.NumMapper;
import cn.wlmb.css.po.Num;
import cn.wlmb.css.po.NumExample;
import cn.wlmb.css.service.NumService;

public class NumServiceImpl implements NumService {

	@Autowired
	private NumMapper numMapper;
	
	@Override
	public List<Num> findNumByExample(NumExample example) {
		return numMapper.selectByExample(example);
	}

}
