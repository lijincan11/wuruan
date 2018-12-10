package com.example.demo.model;

public enum RspStatus {

	SUCCESS(0),GENERAL_FAIL(1),NO_AUTH(2),NO_POWER(3);
	
	private int status;
	
	RspStatus(int status){
		this.status=status;
	}
	
	public int getStatus(){
		return this.status;
	}
}
