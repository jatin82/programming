package com.trip.exception;

public class PlatformException extends Exception {
	
	private String errorMessage;
	
	public PlatformException(String message,Throwable exception) {
		this.errorMessage = exception.getMessage();
	}

}
