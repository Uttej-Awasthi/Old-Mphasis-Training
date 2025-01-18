package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.bean.Employee;
import com.service.EmployeeService;
@TestMethodOrder(OrderAnnotation.class)
class EmployeeServiceTest {

	static EmployeeService es;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		//System.out.println("Before all test method");
		 es = new EmployeeService();
	}
	
	@Test
	@Order(5)
	//@Disabled
	void testSayHello() {
		//EmployeeService es = new EmployeeService();
		String result = es.sayHello("Ravi");
		assertEquals("Welcome to JUnit 5 testing Ravi", result);
	}
	
	@Test
	@Order(4)
	//@Disabled
	public void testCheckUser() {
		//EmployeeService es = new EmployeeService();
		String result = es.checkUser("Ravi", "123");
		assertEquals("failure", result);
	}
	
	@Test
	@Order(3)
	//@Disabled
	public void testUpdateSalary() {
		//EmployeeService es = new EmployeeService();
		Employee emp1= new Employee(1, "Ravi", 45000, "Manager");
		float updatedSalary	 = es.updateSalary(emp1);
		assertEquals(50000, updatedSalary);
	}
	
	@Test
	@Order(6)
	public void testGetEmployeeInfo() {
		//EmployeeService es = new EmployeeService();
		Employee emp = es.getEmployeeInfo();
		assertNotNull(emp);
		assertEquals(15000, emp.getSalary());
	}
	
	@Test 
	@Order(2)
	public void testGetEmloyeeDetails() {
		//EmployeeService es = new EmployeeService();
		List<Employee> listOfEmployees= es.getEmloyeeDetails();
		Employee emp1 = listOfEmployees.get(0);
		assertEquals(listOfEmployees.size(), 3);
		assertEquals(100, emp1.getId());
		assertEquals("Mahesh", emp1.getName());
		assertEquals(18000, emp1.getSalary());
		assertEquals("Programmer", emp1.getDesg());
	}
	
	@Test
	@DisplayName(value = "Employee Details testing from Db")
	@Order(1)
	public void testGetEmployeeDataFromDb() {
		//EmployeeService es = new EmployeeService();
		List<Employee> listOfemp = es.getEmployeeDataFromDb();
		assertEquals(listOfemp.size(), 15);
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		//System.out.println("After all test method");
		es = null;
	}
}


