package cn.wlmb.css.service;

import java.util.List;

import cn.wlmb.css.po.Systemans;
import cn.wlmb.css.po.SystemansExample;

public interface SystemanService {
	/**
	 * 将新纪录插入到数据库中
	 * @param msg 一个Systemans的对象
	 */
	int insertContent(Systemans systemans);
	
	/**
	 * 自定义条件查询Systemans
	 * @param example
	 * @return
	 */
	List<Systemans> findMsgByExample(SystemansExample example);
}
