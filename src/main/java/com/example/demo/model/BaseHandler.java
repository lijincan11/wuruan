package com.example.demo.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseHandler {

	
	public HttpServletRequest req;
	
	public HttpServletResponse resp;
	
	public boolean isFilter;
	
	
	public BaseHandler setReq(HttpServletRequest req){
		
		this.req=req;
		
		return this;
	}
	
	public BaseHandler setResp(HttpServletResponse resp){
		this.resp=resp;
		return this;
	}
	
	/**
	 * 添加进来的 路径  将不会被拦截处理
	 * @param paths
	 * @return
	 */
	public BaseHandler isFilter(String ...paths ){
		String path=req.getRequestURI();
		this.isFilter=true;
		for (int i = 0; i < paths.length; i++) {
			if(path.indexOf(paths[i])>-1){
				this.isFilter=false;
				break;
			}
		}
		return this;
	}
	
	/**
	 * 需要自己实现处理方法  处理前先判断filter
	 * @return
	 * @throws AppHttpException 
	 */
	public boolean handle() throws AppHttpException{
		if(isFilter){
			// handle
			System.out.println("basehandle-->handle this...");
		}
		
		return true;
	}
	
}
