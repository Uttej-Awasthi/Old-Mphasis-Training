package com.main;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import com.bean.Employee;
import com.service.EmployeeService;
public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int id;
		String name;
		float salary;
		String con="";
		int choice;
		String result;
		EmployeeService es = new EmployeeService();
		do {
				System.out.println("1:Display All 2: Insert 3: Delete 4: Update 5: find record by salary");
				System.out.println("Enter your choice");
				choice = sc.nextInt();
				switch (choice) {
				case 1:List<Employee> listOfEmp = es.getAllEmployee();
					   Iterator<Employee> li  = listOfEmp.iterator();
					   while(li.hasNext()) {
						   Employee emp = li.next();
						   System.out.println(emp);
					   }
					break;
				case 2: System.out.println("Enter the id");
				         id = sc.nextInt();
				         System.out.println("Enter the name");
				         name = sc.next();
				         System.out.println("Enter the salary");
				         salary = sc.nextFloat();
				         Employee emp = new Employee(id, name, salary);
				         result = es.storeEmployeeDetails(emp);
				         System.out.println(result);
				         break;
				case 3: System.out.println("Enter the employee id to delete the record");
				        id = sc.nextInt();
				        result = es.deleteEmployee(id);
				        System.out.println(result);
				        break;
				case 4: System.out.println("Enter the id");
				        id = sc.nextInt();
				        System.out.println("Enter the salary");
				        salary = sc.nextFloat();
				        Employee emp1 = new Employee();
				        emp1.setId(id);
				        emp1.setSalary(salary);
				        result = es.updateEmployee(emp1);
				        System.out.println(result);
				        break;
				case 5:System.out.println("Plz enter the salary");
				        salary =sc.nextFloat();
				        List<Employee> listOfEmp1 = es.findSalary(salary);
						   Iterator<Employee> li1  = listOfEmp1.iterator();
						   while(li1.hasNext()) {
							   Employee emp2 = li1.next();
							   System.out.println(emp2);
						   }
						break;
						   
				default:	System.out.println("Wrong choice");
					break;
				}
			System.out.println("Do you want to continue?");
			con = sc.next();
		} while (con.equals("y"));
	}

}
