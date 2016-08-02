package cn.wlmb.css.service;

import java.util.List;

import cn.wlmb.css.po.Msg;
import cn.wlmb.css.po.MsgExample;


public interface MsgService {
	/**
	 * 将消息插入到数据库中
	 * @param msg 一个Msg的对象
	 */
	int insertMsg(Msg msg);
	
	/**
	 * 自定义条件查询msg
	 * @param example
	 * @return
	 */
	List<Msg> findMsgByExample(MsgExample example);
}
