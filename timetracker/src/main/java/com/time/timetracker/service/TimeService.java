package com.time.timetracker.service;


import java.io.IOException;
import java.io.InputStream;
import org.springframework.stereotype.Service;

import com.time.timetracker.pojo.TimeData;

@Service
public class TimeService {

	public boolean createTimeRecord(TimeData timeData)
	{
        try {
			String command = "curl -X POST --data \"email="+timeData.getEmailId()+"\" --data \"start="+timeData.getStartTime()+"\" --data \"end="+timeData.getEndTime()+"\" \"http://localhost:8080/records\"";
			System.out.println("command: "+command);
			Process process = Runtime.getRuntime().exec(command);
			InputStream iSR = process.getInputStream();
			byte[] bstr = iSR.readAllBytes();
			String str = new String(bstr);
			System.out.println("**********Create Output"+str);
			process.destroy();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public String GetTimeRecord(String emailId)
	{
		String str = null;
		try {
			String command = "curl \"http://localhost:8080/records?email="+emailId+"&length=10\"";
			System.out.println("command: "+command);
			Process process = Runtime.getRuntime().exec(command);
			InputStream iSR = process.getInputStream();
			byte[] bstr = iSR.readAllBytes();
			str = new String(bstr);
			System.out.println("**********Get Output"+str);
			process.destroy();
		} catch (IOException e) {
			e.printStackTrace();
			return "Execution Failed";
		}
		return str;
	}
}