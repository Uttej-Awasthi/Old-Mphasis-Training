package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Employee;
import com.dao.EmployeeDao;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	
	public String storeEmployee(Employee emp) {
		if(emp.getSalary()<12000) {
			return "salary must be > 12000";
		}else {
			if(employeeDao.storeEmployee(emp)>0) {
				return "Record stored successfully";
			}else {
				return "Record didn't store";
			}
		}
	}
	
	public List<Employee> getAllEmployee() {
		return employeeDao.getAllEmployee();
	}
	
	
}
