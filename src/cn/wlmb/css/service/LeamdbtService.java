package cn.wlmb.css.service;

import java.util.List;

import cn.wlmb.css.po.Leavemsgdividebytime;
import cn.wlmb.css.po.LeavemsgdividebytimeExample;

public interface LeamdbtService {

	/**
	 * 通过example查询Leavemsgdividebytime
	 * @param example
	 * @return
	 */
	List<Leavemsgdividebytime> findLeadbt(LeavemsgdividebytimeExample example);
}
