package com.hss.renthouse.util;

import java.util.UUID;

/**
 * 返回一个随机编码
 * 
 * @author hss
 *
 */
public class UUIDUtil {

	public static String getUuid(){
		return UUID.randomUUID().toString().replace("-", "");
	}
}
