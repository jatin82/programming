package com.trip.exception;

public class InvalidInputException extends PlatformException{

	private String errorMessage;
	
	public InvalidInputException(String message) {
		super(message,null);
		this.errorMessage = message;
	}

}
