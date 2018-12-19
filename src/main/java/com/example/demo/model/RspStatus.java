package com.example.demo.model;

public enum RspStatus {

	SUCCESS(0),        // 请求成功
	GENERAL_FAIL(1),   //请求失败  一般失败
	NO_AUTH(2),        //没有token
	NO_POWER(3),       //没有权限
	BAD_PARAMS(4),     //错误参数
	UN_KNOW_ERROR(5),  //未知异常
	BAD_USER_INFO(6),  //错误不合法的用户信息
	SERVER_ERROR(7),   //服务器异常
	AUTH_EXPIRED(8),    //token 过期
	BAD_AUTH(9)        //不合法的token
	;
	
	private int status;
	
	RspStatus(int status){
		this.status=status;
	}
	
	public int getStatus(){
		return this.status;
	}
}
