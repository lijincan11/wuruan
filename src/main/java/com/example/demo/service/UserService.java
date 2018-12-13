package com.example.demo.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.example.demo.model.Rsp;
import com.example.demo.model.User;

public interface UserService {

	
	
	Rsp login(User user) throws Exception;
	
	Rsp register(User user);
	
	boolean exist(User user);
	
	boolean isRegistered(User user);
	
	boolean addUser(User user);
	
	User getOne(User user);
	
	List<User> getSome(User user);
	
}
