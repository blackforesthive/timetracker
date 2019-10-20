package com.time.timetracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UiserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(UiserverApplication.class, args);
	}

}
