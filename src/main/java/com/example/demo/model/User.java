package com.example.demo.model;

import javax.validation.constraints.NotBlank;

import com.example.demo.annotation.TokenInclude;

public class User {

	@TokenInclude
	@NotBlank(message="用户名不能为空")
	private String username;
	
	private String password;
	
	@TokenInclude
	private String id;
	
	@TokenInclude
	private String role_id;

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
	
	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	public User(String username, String password, String id) {
		super();
		this.username = username;
		this.password = password;
		this.id = id;
	}
	
	

	public User(String username, String password, String id, String role_id) {
		super();
		this.username = username;
		this.password = password;
		this.id = id;
		this.role_id = role_id;
	}

	public User() {
		super();
	}
	
	
	
	
	
	
}
