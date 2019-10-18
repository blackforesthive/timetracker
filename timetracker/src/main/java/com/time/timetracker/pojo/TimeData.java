package com.time.timetracker.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TimeData {

	@JsonProperty("startTime")
	String startTime;
	
	@JsonProperty("endTime")
	String endTime;
	
	@JsonProperty("emailId")
	String emailId;
	
	public TimeData()
	{
		
	}
	public TimeData(String startTime, String endTime, String emailId)
	{
		this.startTime = startTime;
		this.endTime = endTime;
		this.emailId = emailId;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
}
