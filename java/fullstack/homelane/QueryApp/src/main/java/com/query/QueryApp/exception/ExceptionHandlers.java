package com.query.QueryApp.exception;


import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.query.QueryApp.model.ResponseData;
import com.query.QueryApp.utils.Constants;

import io.jsonwebtoken.JwtException;


@ControllerAdvice
public class ExceptionHandlers {

	ResponseEntity<String> response;

	HttpHeaders headers = new HttpHeaders();
	
	ResponseData data;
		    
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ResponseData> globalHandler(Exception ex,HttpServletRequest request){
		ex.getStackTrace();
		headers.setContentType(MediaType.APPLICATION_JSON);
		ex.printStackTrace();
		System.out.println("Internal Server Exception");
		data = new ResponseData<String>(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),Constants.FAILED,HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<ResponseData>(data,headers,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = JwtException.class)
	public ResponseEntity<ResponseData> JwtHandler(JwtException ex, HttpServletRequest request){
		headers.setContentType(MediaType.APPLICATION_JSON);
		System.out.println("JWT Exception");
		data = new ResponseData<String>(HttpStatus.UNAUTHORIZED.getReasonPhrase(),Constants.FAILED,HttpStatus.UNAUTHORIZED);
		return new ResponseEntity<ResponseData>(data,headers,HttpStatus.BAD_REQUEST);
	}
	
}

