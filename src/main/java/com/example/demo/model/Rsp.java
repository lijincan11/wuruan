package com.example.demo.model;

public class Rsp {
	
	
	private int status;
	
	private String tip;
	
	private String errorMsg;
	
	private Object data;
	

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

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

	public Rsp setData(Object data) {
		this.data = data;
		return this;
	}

	public Rsp(RspStatus statusEnum, String tip) {
		super();
		this.status = statusEnum.getStatus();
		this.tip = tip;
	}
	
	public Rsp(RspStatus statusEnum, String tip,String errorMsg) {
		super();
		this.status = statusEnum.getStatus();
		this.tip = tip;
		this.errorMsg=errorMsg;
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
	
	public static Rsp Exception(RspStatus statusEnum,String errorMsg){
		//TODO need fix
		Rsp rsp=new Rsp(statusEnum, "服务器跑丢了...", errorMsg);
		return rsp;
	}
	
	
	
	
}
