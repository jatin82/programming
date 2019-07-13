package com.query.QueryApp.filter;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.query.QueryApp.model.JwtInterceptor;

@Configuration
@EnableWebMvc
public class InterceptorRegister extends WebMvcConfigurerAdapter 
{
	
	
	@Bean
	public JwtInterceptor jwtInterceptor() {
	    return new JwtInterceptor();
	}
	
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	
    	System.out.println("Interceptor registry");
    	registry.addInterceptor(jwtInterceptor())
    			.addPathPatterns("/api/**");
    }
}

