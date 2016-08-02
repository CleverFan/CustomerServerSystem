package cn.wlmb.css.service;

import java.util.List;

import cn.wlmb.css.po.Servermsg;
import cn.wlmb.css.po.ServermsgExample;

public interface ServermsgService {

	/**
	 * 通过example查询servermsg
	 * @param example
	 * @return
	 */
	List<Servermsg> findServermsgByExample(ServermsgExample example);
}
