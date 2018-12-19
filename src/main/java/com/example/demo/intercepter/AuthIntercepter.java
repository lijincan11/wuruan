package com.example.demo.intercepter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.AuthHandler;
import com.example.demo.model.BaseHandler;

@Component
public class AuthIntercepter implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("进入拦截器");
		System.out.println(request.getRequestURI());
//		return HandlerInterceptor.super.preHandle(request, response, handler);
//		throw new UnsupportedEncodingException();
//		return true;
//		handler=new BaseHandler();
		return new AuthHandler().setReq(request).setResp(response).isFilter("login","register").handle();
//		return new AuthIntercepterHandler().handle()
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
	

}
