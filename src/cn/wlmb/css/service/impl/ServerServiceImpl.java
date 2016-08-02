package cn.wlmb.css.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.wlmb.css.mapper.ServerMapper;
import cn.wlmb.css.po.Server;
import cn.wlmb.css.po.ServerExample;
import cn.wlmb.css.service.ServerService;

public class ServerServiceImpl implements ServerService {

	@Autowired
	private ServerMapper serverMapper;
	
	@Override
	public List<Server> findServerList(ServerExample example) {
		return serverMapper.selectByExample(example);
	}

	@Override
	public int insertServer(Server server) {
		return serverMapper.insert(server);
	}

	@Override
	public boolean isExistServer(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Server findServerById(String id) {
		return serverMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateServerById(Server server) {		
		return serverMapper.updateByPrimaryKey(server);
	}

}
