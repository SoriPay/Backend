package com.example.backend0;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.backend0")
@EnableAutoConfiguration
public class Backend0Application {

	public static void main(String[] args) {
		SpringApplication.run(Backend0Application.class, args);
	}

}