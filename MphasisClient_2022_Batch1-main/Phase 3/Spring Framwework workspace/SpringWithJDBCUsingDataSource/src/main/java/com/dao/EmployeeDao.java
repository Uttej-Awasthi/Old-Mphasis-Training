package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bean.Employee;

@Repository
public class EmployeeDao {

	@Autowired
	DataSource ds1;		// it will pull the ds from xml file. 
	// 	before spring framework we lookup datasource from application server. 
	public List<Employee> getAllEmployee() {
		List<Employee> listOfEmp = new ArrayList<>();		
		try {
			Connection con = ds1.getConnection();
			PreparedStatement pstmt =  con.prepareStatement("select * from employee");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Employee emp = new Employee();				// converting each record into java bean object. 
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setSalary(rs.getFloat("salary"));
				listOfEmp.add(emp);
			}
			return listOfEmp;
		} catch (Exception e) {
		}
		return null;
	}
}
