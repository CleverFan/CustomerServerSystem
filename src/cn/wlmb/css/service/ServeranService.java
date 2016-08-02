package cn.wlmb.css.service;

import java.util.List;


import cn.wlmb.css.po.Serverans;
import cn.wlmb.css.po.ServeransExample;


public interface ServeranService {
	/**
	 * 将新纪录插入到数据库中
	 * @param msg 一个Serverans的对象
	 */
	int insertContent(Serverans serverans);
	
	/**
	 * 自定义条件查询Serverans
	 * @param example
	 * @return
	 */
	List<Serverans> findMsgByExample(ServeransExample example);
}
