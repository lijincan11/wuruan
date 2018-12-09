package com.example.demo.util;

import java.util.UUID;

public class UUIDUtil {
	
	/**
	 * 返回一个随机字符串
	 */
	public static String  randomString(){
		
		
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

}
