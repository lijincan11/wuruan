package com.example.demo.controller;

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

}
