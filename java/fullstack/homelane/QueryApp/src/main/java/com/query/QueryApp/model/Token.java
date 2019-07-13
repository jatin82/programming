package com.query.QueryApp.model;


import org.springframework.stereotype.Component;

@Component
public class Token {

	
	private String token;
	private String type;
	
	
	public Token() {}
	
	
	
	public Token(String type, String token) {
		super();
		this.token = token;
		this.type = type;
	}



	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Token [token=" + token + ", type=" + type + "]";
	}
	
	
	
}

