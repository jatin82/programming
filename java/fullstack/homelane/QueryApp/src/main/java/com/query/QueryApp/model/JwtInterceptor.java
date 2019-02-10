package com.query.QueryApp.model;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.query.QueryApp.utils.Constants;
import com.query.QueryApp.utils.JwtUtil;

import io.jsonwebtoken.JwtException;


public class JwtInterceptor extends HandlerInterceptorAdapter{

	@Autowired
	JwtUtil jwt;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception{
		String type = ((HttpServletRequest) request).getMethod();
		String url =  ((HttpServletRequest) request).getRequestURL().toString();
		System.out.print(getClass().getSimpleName() + " : "+type + " : "+url);
		if(type.equals(Constants.OPTIONS)) {
			return true;
		}
		String jwttoken = request.getHeader(Constants.JWTTOKEN);
		if (!ObjectUtils.isEmpty(jwttoken)) {
			Token token = new Token(Constants.JWTTOKEN, jwttoken);
			User user = jwt.parseAuthToken(token);
			if (user == null || !user.getPassword().equals("password") || !user.getRole().equals("admin") || !user.getUserName().equals("homelane"))
			{
				System.out.println(" : Invalid Token");
				throw new JwtException("Invalid Token");
			}
			else {
				Date date = new Date();
				long diff = date.getTime() - user.getExpiryDate().getTime();
				diff = diff - Constants.VALIDTOKENTIME * 60 * 60 * 1000;
				if(diff>0) {
					System.out.println("Token expired");
					throw new JwtException("Token Expired");
				}
			}
			return true;
		}
		throw new JwtException("JWT Token missing");
	}
}
