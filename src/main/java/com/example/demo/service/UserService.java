package com.example.demo.service;

import com.example.demo.model.Rsp;
import com.example.demo.model.User;

public interface UserService {

	
	
	Rsp login(User user);
	
	Rsp register(User user);
	
	boolean exist(User user);
	
	boolean isRegistered(User user);
	
	boolean addUser(User user);
	
}
