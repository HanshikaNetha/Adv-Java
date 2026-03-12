package com.example.SecurityStudentManagmentSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SecurityStudentManagmentSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityStudentManagmentSystemApplication.class, args);
	}
}
