package com.tarento.studentrest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@SpringBootApplication
public class StudentrestApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentrestApplication.class, args);
	}
	
	
	

}
