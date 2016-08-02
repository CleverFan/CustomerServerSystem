package cn.wlmb.css.service;

import java.util.List;

import cn.wlmb.css.po.Currentstate;
import cn.wlmb.css.po.CurrentstateExample;


public interface CurrentStateService {
	
	/**
	 * 自定义条件查询msg
	 * @param example
	 * @return
	 */
	List<Currentstate> findCurrentstateByExample(CurrentstateExample example);
}
