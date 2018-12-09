package com.example.demo.controller;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserDao;
import com.example.demo.model.Rsp;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	UserService userService;

	
	
	@RequestMapping("/getAllUser")
	List<User> getAllUser(){

		return userDao.getAllUser();
	}
	
	@RequestMapping("/updateUser")
	int updateUser(@RequestBody User user){
		
		return userDao.updateUser(user);
	}
	
	
	
	
	
	@RequestMapping("/deleteUser")
	int deleteUser(@RequestBody User user){
		
		return userDao.deleteUser(user);
	}
	
	@RequestMapping("/login")
	Rsp login(@RequestBody User user){
		
		
		return userService.login(user);
	}
	
	@RequestMapping("/register")
	Rsp register(@RequestBody User user){
		
		
		return userService.register(user);
	}
	
	
	
	@RequestMapping("/insertUser")
	int insertUser(@RequestBody User user){
		
		return userDao.insertUser(user);
	}
	
	
	
	
	
	
}
