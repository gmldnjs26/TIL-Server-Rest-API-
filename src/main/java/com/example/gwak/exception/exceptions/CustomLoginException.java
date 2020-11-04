package com.example.gwak.exception.exceptions;

public class CustomLoginException extends Exception {
	
	
	private final String ERR_CODE; //  7xx;
	
	/**
     * Constructor
     *
     * @param message, errorCode
     */
	public CustomLoginException(String msg,String err_code) {
		super(msg);
		this.ERR_CODE = err_code;
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}
	
	public String getErrCode() {
		return ERR_CODE;
	}
	
	

}
