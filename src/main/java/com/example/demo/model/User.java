package com.example.demo.model;

import javax.validation.constraints.NotBlank;

public class User {

	@NotBlank(message="用户名不能为空")
	private String username;
	
	private String password;
	
	private String id;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User(String username, String password, String id) {
		super();
		this.username = username;
		this.password = password;
		this.id = id;
	}

	public User() {
		super();
	}
	
	
	
	
	
	
}
