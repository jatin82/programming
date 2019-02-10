package com.query.QueryApp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.query.QueryApp.model.ResponseData;

@Component
public class DataService {

	@Value("${data.service.uri}")
	private String dataUri;
	
	
	public ResponseData callRestService(String parameter,String type){
		RestTemplate restTemplate = new RestTemplate();
		ResponseData data = restTemplate.getForObject(dataUri+"?"+type+"="+parameter, ResponseData.class);
		return data;
	}
	
	
}
