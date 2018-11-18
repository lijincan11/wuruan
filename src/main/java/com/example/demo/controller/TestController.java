package com.example.demo.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	
	
	@RequestMapping("/hello/{name}")
	public String hello(@PathVariable("name") String name){
		
		System.out.println("hello"+name);
		
		return "hello "+name+"!!!!~~~";
	}
	
	
	
	@RequestMapping("/play/{name}")
	public String play(@PathVariable("name") String name){
		
		System.out.println("hello"+name);
		
		return "tom在打 "+name+"游戏!!!!~~~";
	}
	
	@RequestMapping("/getTime")
	public String getTime(){
		
		DateFormat bf = new SimpleDateFormat("yyyy-MM-dd E a HH:mm:ss");//多态
		
		return "当前的时间是："+bf.format(new Date());
	}

}
