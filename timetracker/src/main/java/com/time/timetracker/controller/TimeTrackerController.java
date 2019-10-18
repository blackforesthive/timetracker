package com.time.timetracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.time.timetracker.pojo.TimeData;
import com.time.timetracker.service.TimeService;

@RestController
@RequestMapping("/timedata")
public class TimeTrackerController {


	@Autowired 
	TimeService timeService;
	
	
	@GetMapping("/searchByemailId")
	public ResponseEntity<String> searchByemailId(@RequestParam(value="emailId") String emailId)
	{
			String strTimeData = timeService.GetTimeRecord(emailId);
			return new ResponseEntity<String>(strTimeData,HttpStatus.OK );
	}
	
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
