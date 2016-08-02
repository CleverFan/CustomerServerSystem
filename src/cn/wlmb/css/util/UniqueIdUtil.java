package cn.wlmb.css.util;

import java.util.UUID;


/**
 * 产生一个唯一ID
 */
public class UniqueIdUtil {

	/**
	 * 产生guid 不带连字符-
	 * 
	 * @return
	 */
	public static final String getGuidNoDash() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/**
	 * 产生guid
	 * 
	 * @return
	 */
	public static final String getGuid() {
		return UUID.randomUUID().toString();
	}

}