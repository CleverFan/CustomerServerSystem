package cn.wlmb.css.service;

import java.util.List;

import cn.wlmb.css.po.Leavemessage;
import cn.wlmb.css.po.LeavemessageExample;

public interface LeaveMessageService {
	/**
	 * 按条件查询留言
	 * @param example
	 * @return
	 */
	List<Leavemessage> findLeaveMsgList(LeavemessageExample example);
}
