package com;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoTest implements CommandLineRunner{
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Run method called..");
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.scan("com");		// scan com package. 
		ac.refresh();		// ready to pull the Employee object 
		Employee emp = (Employee)ac.getBean("employee");
		//emp.display();	
		System.out.println(emp);
		emp.setId(100);
		emp.setName("Ravi");
		emp.setSalary(12000);
		System.out.println(emp);
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoTest.class, args);		// Run spring boot application 
	}

}
