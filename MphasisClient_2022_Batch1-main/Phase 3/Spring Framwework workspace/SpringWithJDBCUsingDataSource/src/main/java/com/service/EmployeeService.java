package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Employee;
import com.dao.EmployeeDao;
@Service
public class EmployeeService {

	@Autowired
	EmployeeDao employeeDao;			// by Name DI with autowired features. 
	
	
	public List<Employee> getAllEmployee() {
		return employeeDao.getAllEmployee();
	}
	
	
}
