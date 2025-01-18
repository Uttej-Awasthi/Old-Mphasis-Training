package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com")
@EntityScan(basePackages = "com.bean")
public class SpringBootRestWithCrudOperationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestWithCrudOperationApplication.class, args);
		System.out.println("Server is ready to run...");
	}

}
