package com.query.QueryApp.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.query.QueryApp.model.ResponseData;
import com.query.QueryApp.service.DataService;
import com.query.QueryApp.utils.Constants;

@RestController
public class PlayersController {

	
	@Autowired
	private DataService service;
	
	@GetMapping("/api/info")
	public ResponseEntity<ResponseData> getPlayerInfoByNameController(@PathParam("name") String name, @PathParam("club") String club){
		
			if(ObjectUtils.isEmpty(name) && ObjectUtils.isEmpty(club)) {
				return new ResponseEntity<ResponseData>(
						new ResponseData<String>("No parameter found", Constants.FAILED, HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
			}
			else if(!ObjectUtils.isEmpty(name) && !ObjectUtils.isEmpty(club)) {
				return new ResponseEntity<ResponseData>(
						new ResponseData<String>("Both parameter cannot be send", Constants.FAILED, HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
			}
			else {
				ResponseData data = null;
				if(!ObjectUtils.isEmpty(name)) {
					data = service.callRestService(name,"name");	
				}
				else {
					data = service.callRestService(club,"club");
				}
				return new ResponseEntity<ResponseData>(
						new ResponseData<ResponseData>(data, Constants.SUCCESS, HttpStatus.OK), HttpStatus.OK);

			}
			
	}

}
