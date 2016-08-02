package cn.wlmb.css.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.wlmb.css.mapper.ServeransMapper;
import cn.wlmb.css.po.Serverans;
import cn.wlmb.css.po.ServeransExample;
import cn.wlmb.css.service.ServeranService;

public class ServeranServiceImpl implements ServeranService {

	@Autowired
	private ServeransMapper serveransMapper;
	
	@Override
	public int insertContent(Serverans serverans) {
		return serveransMapper.insert(serverans);
	}

	@Override
	public List<Serverans> findMsgByExample(ServeransExample example) {
		return serveransMapper.selectByExample(example);
	}

}
