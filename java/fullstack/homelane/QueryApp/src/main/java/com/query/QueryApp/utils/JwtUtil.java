package com.query.QueryApp.utils;


import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.query.QueryApp.model.Token;
import com.query.QueryApp.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Component
public class JwtUtil {

    @Value("${jwt.secret.decoded}")
    private String secret;

    
    public User parseAuthToken(Token token) {
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token.getToken())
                    .getBody();

            User user = new User();
            user.setRole((String) body.get("role"));
            user.setUserName((String) body.get("name"));
            user.setPassword((String) body.get("password"));
            user.setExpiryDate(new Date((long) body.get("date")));
            
            return user;

        } catch (JwtException | ClassCastException e) {
        	System.out.println("Cannot parse Token");
            return null;
        }
    }

    
    /**
     * Generate token.
     *
     * @param user the user
     * @return the string
     */
    public Token generateAuthToken(User user,String type) {
        Claims claims = Jwts.claims();
        claims.put("role", user.getRole());
        claims.put("date",user.getExpiryDate().getTime());
        claims.put("name", user.getUserName());
        claims.put("password", user.getPassword());
        
        Token token = new Token();
        token.setToken(Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact());
        token.setType(type);
        return token;
    }
    
    public String encryptToken(String key,String type) {
        Claims claims = Jwts.claims();
        claims.put(type, key);
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
    
    public String decryptToken(String token,String type) {
    	try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            String key = body.get(type).toString();
            return key;
        } catch (JwtException | ClassCastException e) {
        	System.out.println("Cannot parse Token");
        	throw e;
        }
    }
    
}