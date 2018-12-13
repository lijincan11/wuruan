package com.example.demo.model;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.io.UnsupportedEncodingException;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
	
	
	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	public Rsp handle(Exception e){
	
		 if(e instanceof MethodArgumentNotValidException){// 处理参数校验的异常
			 MethodArgumentNotValidException exception=(MethodArgumentNotValidException)e;
			 return Rsp.Fail(RspStatus.BAD_PARAMS, exception.getBindingResult().getFieldError().getDefaultMessage());
		 }else if(e instanceof IllegalArgumentException){
			 return Rsp.Exception(RspStatus.BAD_USER_INFO, "用户信息不完整");
		 }else if(e instanceof UnsupportedEncodingException){
			 return Rsp.Exception(RspStatus.SERVER_ERROR, "token加密或解密失败");
		 }else{
			 return Rsp.Fail(RspStatus.UN_KNOW_ERROR, "服务器跑丢了...");
		 }
		
		 
	}

}
