package com.time.gettime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.time.gettime.service.TimeService;

@RestController
@RequestMapping("/gettime")
@ComponentScan(basePackages="com.time.gettime")
public class GetTimeTrackerController {

	@Autowired 
	TimeService timeService;
	
	@GetMapping("/searchByemailId")
	public ResponseEntity<String> searchByemailId(@RequestParam(value="emailId") String emailId)
	{
			String strTimeData = timeService.GetTimeRecord(emailId);
		/*
		 * HttpHeaders responseHeaders = new HttpHeaders();
		 * responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		 * responseHeaders.add("Access-Control-Allow-Origin", "*");
		 */	return new ResponseEntity<String>(strTimeData, HttpStatus.OK );
	}
}
