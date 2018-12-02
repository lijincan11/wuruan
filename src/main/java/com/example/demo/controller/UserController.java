package com.example.demo.controller;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserDao userDao;

	
	
	@RequestMapping("/getAllUser")
	List<User> getAllUser(){
		
		
		return userDao.getAllUser();
	}
	
	
//	int updateUser(User user){
//		
//	}
//	
//	
//	int deleteUser(User user){
//		
//	}
//	
//	int insertUser(User user){
//		
//	}
	
	
	
	
	
}
