package com.panda.distributed;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class DistributedSomeApplication {
	
	@Value("${my.message}") //通过@Value注入的值来自Config Server
	private String message;
	
	@RequestMapping(value="/getsome")
	public String getsome() {
		return message;
	}

	public static void main(String[] args) {
		SpringApplication.run(DistributedSomeApplication.class, args);
	}
}
