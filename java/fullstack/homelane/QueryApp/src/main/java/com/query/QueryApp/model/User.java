package com.query.QueryApp.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {

	@JsonIgnore
	private Date expiryDate;
	private String userName;
	private String role;
	private String password;
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [expiryDate=" + expiryDate + ", userName=" + userName + ", role=" + role + ", password=" + password
				+ "]";
	}
	
	
}
