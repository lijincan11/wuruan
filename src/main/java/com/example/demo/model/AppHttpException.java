package com.example.demo.model;


public class AppHttpException extends Exception {

	
	public RspStatus status;

    public AppHttpException(RspStatus status, String errMsg) {
        super(errMsg);
        this.status = status;
    }

	public RspStatus getStatus() {
		return status;
	}

	public void setStatus(RspStatus status) {
		this.status = status;
	}

   
	
	
	
}



