package cn.wlmb.css.service;

import java.util.List;

import cn.wlmb.css.po.Num;
import cn.wlmb.css.po.NumExample;

/**
 * 通过example查询num
 * @author ChengFan
 *
 */
public interface NumService {
	
	List<Num> findNumByExample(NumExample example);
}
