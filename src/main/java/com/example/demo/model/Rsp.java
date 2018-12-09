package com.example.demo.model;

public class Rsp {
	
	
	private int status;
	
	private String tip;
	
	private Object data;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Rsp(int status, String tip) {
		super();
		this.status = status;
		this.tip = tip;
	}

	public Rsp() {
		super();
	}
	
	
	public static Rsp Success(){
		Rsp rsp=new Rsp(0, "successs");
		return rsp;
	}
	
	public static Rsp Fail(){
		Rsp rsp=new Rsp(1, "fail");
		return rsp;
	}
	
	

	
	
	
}
