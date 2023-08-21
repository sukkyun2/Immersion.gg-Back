package com.immersion.riot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RiotApplication {

	public static void main(String[] args) {
		SpringApplication.run(RiotApplication.class, args);
	}

}
