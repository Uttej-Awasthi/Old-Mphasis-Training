package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.Employee;
import com.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value = "/storeEmployee")
	public String storeEmployee(@RequestParam("name1") String name, 
			@RequestParam("salary1") float salary, Employee emp,Model mm) {
			emp.setName(name);
			emp.setSalary(salary);
			//System.out.println(emp.getName()+" "+emp.getSalary());
			String result = employeeService.storeEmployee(emp);
			mm.addAttribute("msg", result);      // HttpServletRequest req, req.setAttribute("msg",result);
			System.out.println(result);
			return "addEmployee";
	}
	@RequestMapping(value = "/openSpringForm")
	public String openSpringFormTag(@ModelAttribute("emp") Employee emp) {		// DI for Employee class 
																				// object store in model attribut 
		return "insertEmployee";																		//scope with key as emp		
	}
	@RequestMapping(value = "/insertEmployee",method = RequestMethod.POST)
	public String insertEmployeeDetails(@ModelAttribute("emp")Employee emp, Model mm) {
		String result = employeeService.storeEmployee(emp);
		emp.setName("");
		emp.setSalary(0.0f);
		mm.addAttribute("msg", result);      // HttpServletRequest req, req.setAttribute("msg",result);
		System.out.println(result);
		return "insertEmployee";
	}
	@RequestMapping(value="/displayEmployee")
	public String displayEmployeeDetails(Model mm) {
		List<Employee> listOfEmp = employeeService.getAllEmployee();
		mm.addAttribute("listOfEmployee", listOfEmp);	// req.setAttribute("listOfEmployee",listOfEmp);
		return "display";
	}
}









