package com.query.QueryApp.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.query.QueryApp.exception.PlatformException;
import com.query.QueryApp.model.ResponseData;
import com.query.QueryApp.model.Token;
import com.query.QueryApp.model.User;
import com.query.QueryApp.utils.Constants;
import com.query.QueryApp.utils.JwtUtil;

@RestController
public class JwtTokenController {

	
	@Autowired
	JwtUtil jwt;
	
	@PostMapping("/token")
	public ResponseEntity<ResponseData> getToken(@RequestBody User user)
			throws PlatformException {
			
			user.setExpiryDate(new Date());
			Token token = jwt.generateAuthToken(user, Constants.JWTTOKEN);
			
			return new ResponseEntity<ResponseData>(
					new ResponseData<Token>(token, Constants.SUCCESS, HttpStatus.OK), HttpStatus.OK);
	}
}
