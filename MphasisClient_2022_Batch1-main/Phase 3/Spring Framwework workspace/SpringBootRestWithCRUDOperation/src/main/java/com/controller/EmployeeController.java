package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Employee;
import com.service.EmployeeService;

// http://localhost:8080/employees/
@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
//	@RequestMapping(value = "getAllEmployee",method = RequestMethod.GET)
//	public List<Employee> getAllEmployees() {
//		return employeeService.getAllEmployee();
//	}
	// http://localhost:8080/employees/getAllEmployee
	@GetMapping(value = "getAllEmployee")
	public List<Employee> getAllEmployees() {
	return employeeService.getAllEmployee();
	}
	// http://localhost:8080/employees/storeEmployee
	@PostMapping(value="storeEmployee")
	public String storeEmployee(@RequestBody Employee emp) {
		return employeeService.storeEmployee(emp);
	}
	// http://localhost:8080/employees/updateEmployee
	@PutMapping(value = "updateEmployee")
	public String updateEmploye(@RequestBody Employee emp) {
		return employeeService.updateEmployee(emp);
	}
	// http://localhost:8080/employees/deleteEmployee/1
	@DeleteMapping(value = "deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {
		return employeeService.deleteEmployee(id);
	}
}

