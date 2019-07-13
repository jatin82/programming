package com.query.QueryApp.model;
import org.springframework.http.HttpStatus;


public class ResponseData<T> {

	private T data;
	private String message;
	private HttpStatus status;
	
	
	public ResponseData(){}
	public ResponseData(T data,String message, HttpStatus status) {
		this.data = data;
		this.message = message;
		this.status = status;
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
}

