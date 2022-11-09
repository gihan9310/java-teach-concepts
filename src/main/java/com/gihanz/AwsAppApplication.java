package com.gihanz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
public class AwsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsAppApplication.class, args);
	}

}
