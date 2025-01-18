package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Employee;

@RestController // @Controller + @ResponseBody 
public class SimpleController {

	// http://localhost:8080/say
	@RequestMapping(value = "/say")
	public String sayHello() {
		return "Welcome to Simple Spring boot REST API";
	}
	// http://localhost:8080/sayHtml
	@RequestMapping(value = "/sayHtml",produces = MediaType.TEXT_HTML_VALUE)
	public String sayHtml() {
		return "<a>Welcome to Simple Message</a>";
	}
	// http://localhost:8080/sayText
	@RequestMapping(value = "/sayText",produces = MediaType.TEXT_PLAIN_VALUE)
	public String sayPlainText() {
		return "<h1>Welcome to Simple Message<h1>";
	}
	// http://localhost:8080/sayXml
	@RequestMapping(value = "/sayXml",produces = MediaType.TEXT_XML_VALUE)
	public String sayXml() {
		return "<a>Welcome to Simple Message</a>";
	}
	// http://localhost:8080/empInfo
	@RequestMapping(value = "empInfo",produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployee() {
		Employee emp = new Employee(101, "RAvi", 12000);
		return emp;
	}
	// http://localhost:8080/employees 
	@RequestMapping(value = "employees",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getAllEmployeeDetails() {
		List<Employee> listOfEmp = new ArrayList<>();
		Employee emp1 = new Employee(1, "Raju", 15000);
		Employee emp2 = new Employee(2, "Ravi", 18000);
		Employee emp3 = new Employee(3, "Rajesh", 20000);
		listOfEmp.add(emp1);
		listOfEmp.add(emp2);
		listOfEmp.add(emp3);
		return listOfEmp;
	}
	// http://localhost:8080/queryParam?name=Ravi
	@RequestMapping(value ="queryParam",method = RequestMethod.GET)
	public String singleQueryParam(@RequestParam("name") String name) {
		return "Welcome to Spring rest with query param "+name;
	}
	// http://localhost:8080/queryCheck?name=Raj&pass=123
	@RequestMapping(value ="queryCheck",method = RequestMethod.GET)
	public String queryCheck(@RequestParam("name") String name, @RequestParam("pass") String pass) {
			if(name.equals("Raj") && pass.equals("123")) {
				return "success";
			}else {
				return "failure";
			}
	}
	// http://localhost:8080/pathParam/Ravi
	@RequestMapping(value = "pathParam/{name}",method = RequestMethod.GET)
	public String singlePathParam(@PathVariable("name") String name) {
		return "Welcome to Spring rest with path param "+name;
	}
	// http://localhost:8080/pathCheck/Ravi/123
	@RequestMapping(value ="pathCheck",method = RequestMethod.GET)
	public String pathCheck(@PathVariable("name") String name, @PathVariable("pass") String pass) {
			if(name.equals("Raj") && pass.equals("123")) {
				return "success";
			}else {
				return "failure";
			}
	}
	
	// http://localhost:8080/storeEmployee 			// whole object in json format 
	@RequestMapping(value = "storeEmployee",method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeData(@RequestBody Employee emp) {
		System.out.println(" Post method called...");
		System.out.println(emp);
		
		// logic to call service layer from there dao layer to store the data.
		
		return "Post method called "+emp.getName();
	}
	
	// http://localhost:8080/updateEmployee 		// partial object in json format. 
		@RequestMapping(value = "updateEmployee",method = RequestMethod.PUT,
				consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateData(@RequestBody Employee emp) {
			System.out.println(" Put method called...");
			System.out.println(emp);
			
			// logic to call service layer from there dao layer to store the data.
			
		return "Put method called "+emp.getName();
	}
		// http://localhost:8080/deleteEmployee/100
		@RequestMapping(value = "deleteEmployee/{id}",method = RequestMethod.DELETE)
		public String deleteData(@PathVariable("id") int id) {
			System.out.println("Delete method called..");
			// logic to call service layer it will dao in dao we write database logic to delete the record. 
			return "You record deleted using id as "+id;
		}
	
}
