package com.example.demo.config;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.example.demo.intercepter.AuthIntercepter;

@SpringBootConfiguration
public class AuthIntercepterConfig extends WebMvcConfigurerAdapter{
	
	@Autowired
	private AuthIntercepter authIntercepter;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		
		registry.addInterceptor(authIntercepter).addPathPatterns("/**");
//		.excludePathPatterns("/static/*");
		super.addInterceptors(registry);
	}
	
	
	
	
	
	

}
