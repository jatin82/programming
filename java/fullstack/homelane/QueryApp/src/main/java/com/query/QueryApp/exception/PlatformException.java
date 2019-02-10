package com.query.QueryApp.exception;


import org.springframework.http.HttpStatus;

public class PlatformException  extends Exception{

	private String message;
	
	private HttpStatus status;
	
	public PlatformException(String message, HttpStatus status) {
		this.message = message;
		this.status = status;
	}
	
}

