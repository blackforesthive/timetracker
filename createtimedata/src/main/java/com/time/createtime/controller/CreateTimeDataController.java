package com.time.createtime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.time.createtime.pojo.TimeData;
import com.time.createtime.service.TimeService;


@RestController
@RequestMapping("/createtime")
@ComponentScan(basePackages="com.time.createtime")
public class CreateTimeDataController {

	@Autowired 
	TimeService timeService;
	
	@PostMapping("/create")
	public ResponseEntity<String> createTimeRecord(@RequestParam("startTime") String startTime, @RequestParam("endTime") String endTime,
			@RequestParam("emailId") String emailId)
	{
		TimeData tempTimeData = new TimeData();
		tempTimeData.setStartTime(startTime);
		tempTimeData.setEndTime(endTime);
		tempTimeData.setEmailId(emailId);
		
		boolean  bResult= timeService.createTimeRecord(tempTimeData);
		if(bResult)
			return new ResponseEntity<String>(HttpStatus.OK );
		else
			return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED );
	}
	
}
