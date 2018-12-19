package com.example.demo.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.util.StringUtils.*;

public class AuthHandler extends BaseHandler{
	
	public final static String AUTH_TOKEN_NAME="auth";

	@Override
	public BaseHandler setReq(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return super.setReq(req);
	}

	@Override
	public BaseHandler setResp(HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return super.setResp(resp);
	}

	@Override
	public BaseHandler isFilter(String... paths) {
		// TODO Auto-generated method stub
		return super.isFilter(paths);
	}

	@Override
	public boolean handle() throws AppHttpException {
		// TODO Auto-generated method stub
		String authToken=super.req.getHeader(AUTH_TOKEN_NAME);
		if(super.isFilter){
			System.out.println("AuthHandler----> handle");
			if(isEmpty(authToken)){
				throw new AppHttpException(RspStatus.NO_AUTH, "token 缺失");
			}
		}
		return true;
	}


	
	
	
}
