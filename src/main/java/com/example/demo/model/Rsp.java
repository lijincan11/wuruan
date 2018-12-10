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

	public Rsp(RspStatus statusEnum, String tip) {
		super();
		this.status = statusEnum.getStatus();
		this.tip = tip;
	}
	
	public Rsp(String tip,Object data) {
		super();
		this.data = data;
		this.tip = tip;
	}

	public Rsp() {
		super();
	}
	
	
	public static Rsp Success(String tip){
		Rsp rsp=new Rsp(RspStatus.SUCCESS, tip);
		return rsp;
	}
	
	public static Rsp Success(String tip,Object data){
		Rsp rsp=new Rsp(tip, data);
		return rsp;
	}
	
	public static Rsp Fail(String tip){
		Rsp rsp=new Rsp(RspStatus.GENERAL_FAIL, tip);
		return rsp;
	}
	
	public static Rsp Fail(RspStatus statusEnum,String tip){
		Rsp rsp=new Rsp(statusEnum, tip);
		return rsp;
	}
	

	
	
	
}
