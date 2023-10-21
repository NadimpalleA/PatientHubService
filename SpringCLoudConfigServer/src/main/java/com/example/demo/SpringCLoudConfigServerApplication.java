package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringCLoudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCLoudConfigServerApplication.class, args);
		System.out.println("Spring Cloud Config Server Application");
	}

}
