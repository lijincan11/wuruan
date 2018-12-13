package com.example.demo.controller;


import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Rsp;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;

	
	
	@RequestMapping("/login")
	Rsp login(@RequestBody @Valid User user) throws Exception{
		return userService.login(user);
	}
	
	@RequestMapping("/register")
	Rsp register(@RequestBody User user){
		return userService.register(user);
	}
	
	
	
}
