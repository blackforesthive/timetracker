package com.time.gettime.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Service;

@Service
public class TimeService {

	public String GetTimeRecord(String emailId)
	{
		String str = null;
		try {
			String command = "curl \"http://timetrackerlegacy:8080/records?email="+emailId+"&length=10\"";
			System.out.println("command: "+command);
			
			ProcessBuilder processBuilder = new ProcessBuilder("bash", "-c", command);
			processBuilder.directory(new File("/home/"));
			
			Process process = processBuilder.start();
			InputStream iSR = process.getInputStream();
			
			byte[] bstr = iSR.readAllBytes();
			str = new String(bstr);
			System.out.println("**********Get Output"+str);
			str = str.replaceAll(", null","");
			process.destroy();
		} catch (IOException e) {
			e.printStackTrace();
			return "Execution Failed";
		}
		return str;
	}
	
}
