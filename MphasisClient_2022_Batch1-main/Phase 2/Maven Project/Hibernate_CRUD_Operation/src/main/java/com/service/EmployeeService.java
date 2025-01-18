package com.service;

import java.util.List;
import com.bean.Employee;
import com.dao.EmployeeDao;
public class EmployeeService {
	EmployeeDao ed;
	public EmployeeService() {
		ed = new EmployeeDao();
	}
	public List<Employee> getAllEmployee() {
		//EmployeeDao ed = new EmployeeDao();	
		return ed.getAllEmployee();
	}
	public String storeEmployeeDetails(Employee emp) {	
		//EmployeeDao ed = new EmployeeDao();
		if(ed.storeEmployee(emp)>0) {
			return "Record stored successfully";
		}else {
			return "Record didn't store";
		}
	}
	public String deleteEmployee(int id) {
		if(ed.deleteEmployee(id)>0) {
			return "Record deleted successfully";
		}else {
			return "Record not present";
		}
	}
	public String updateEmployee(Employee emp) {
		if(ed.updatemployee(emp)>0) {
			return "Record updated";
		}else {
			return "Record didn't update";
		}
	}
	
	public List<Employee> findSalary(float salary){
		return ed.findBySalary(salary);
	}
	
}
