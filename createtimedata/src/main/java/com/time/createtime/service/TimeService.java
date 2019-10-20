package com.time.createtime.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.time.createtime.pojo.TimeData;

@Service
@ComponentScan(basePackages="com.time.createtime")
public class TimeService {

	public boolean createTimeRecord(TimeData timeData)
	{
        try {
			String command = "curl -X POST --data \"email="+timeData.getEmailId()+"\" --data \"start="+timeData.getStartTime()+"\" --data \"end="+timeData.getEndTime()+"\" \"http://timetrackerlegacy:8080/records\"";
			System.out.println("command: "+command);
			
			ProcessBuilder processBuilder = new ProcessBuilder("bash", "-c", command);
			processBuilder.directory(new File("/home/"));
			
			Process process = processBuilder.start();
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
}
