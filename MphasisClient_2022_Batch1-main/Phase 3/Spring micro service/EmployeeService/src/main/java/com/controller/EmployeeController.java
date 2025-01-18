package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("employee")
public class EmployeeController {

	@GetMapping(value = "/getInfo")
	public String getEmloyeeInfo() {
		return "Welcome to Employee micro service";
	}
	
	@GetMapping(value = "/customerInfo")
	public String callCustomerMicroService() {
		String result = restTemplate.getForObject("http://localhost:8181/customer/getInfo", String.class);
		return result;
	}
	@Autowired
	RestTemplate restTemplate;				// This api is uses to call another micro service. 
	
	@Bean
	public RestTemplate restTemplate() {		// this method is responsible to give the object of resttemplate
		return new RestTemplate();
	}
}
