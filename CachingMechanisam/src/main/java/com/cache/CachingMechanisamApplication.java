package com.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CachingMechanisamApplication {

	public static void main(String[] args) {
		SpringApplication.run(CachingMechanisamApplication.class, args);
		
		System.out.println("Cacheable Application is developed");
	}

}
