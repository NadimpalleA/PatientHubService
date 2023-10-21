package com.patient.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbPatientAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbPatientAppApplication.class, args);
		System.out.println("Spring Boot Patient Application");
	}
	
}
