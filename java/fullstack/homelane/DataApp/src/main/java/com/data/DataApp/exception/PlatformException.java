package com.data.DataApp.exception;


import org.springframework.http.HttpStatus;

public class PlatformException  extends Exception{

	private String message;
	
	private HttpStatus status;
	
	public PlatformException(String message, HttpStatus status) {
		this.message = message;
		this.status = status;
	}
	
}

