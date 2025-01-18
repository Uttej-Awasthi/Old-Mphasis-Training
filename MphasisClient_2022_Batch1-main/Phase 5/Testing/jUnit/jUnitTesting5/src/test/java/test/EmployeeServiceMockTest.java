package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bean.Employee;
import com.dao.EmployeeDao;
import com.service.EmployeeService;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceMockTest {
	
	@Mock
	EmployeeDao employeeDao;
	
	@InjectMocks
	EmployeeService employeeService;
	
	@Test
	void testGetEmployeeDataFromDb() {
		//Fake Data
		Employee emp1 = new Employee(1, "Ravi", 12000, "Tester");
		Employee emp2 = new Employee(2,"Ramesh",14000,"Programmer");
		List<Employee> listOfFakeEmployee = new ArrayList<>();
		listOfFakeEmployee.add(emp1);
		listOfFakeEmployee.add(emp2);
		
		Mockito.when(employeeDao.getAllEmployeeDetails()).thenReturn(listOfFakeEmployee);
		
		
		List<Employee> listOfemp = employeeService.getEmployeeDataFromDb();
		System.out.println(listOfemp);
		assertEquals(2, listOfemp.size());
	}
	
	@Test 
	public void testStoreRecord() {
		Employee emp1 = new Employee(100, "ajay", 15000, "Manager");
		
		
		Mockito.when(employeeDao.storeEmployeeDetails(emp1)).thenReturn(1);
		
		
		String result = employeeService.storeRecord(emp1);
		assertEquals("Record inserted", result);
	}

}
