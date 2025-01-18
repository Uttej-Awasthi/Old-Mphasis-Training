package com;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DemoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration con = new Configuration();// configuration class object created
		con.configure("hibernate.cfg.xml");
		System.out.println("file loaded succesfully");
		//load the driver, connected the database 
		SessionFactory sf = con.buildSessionFactory();	// Connection con 
		Session session = sf.openSession();		// it is like a Stament or PreparedStatement 
		Transaction tran = session.getTransaction();
		
		// Insert Operation 
//		Employee emp = new Employee();
//		emp.setId(7);
//		emp.setName("Mahesh");
//		emp.setSalary(25000);
//		tran.begin();
//					session.save(emp);			// insert query
//		tran.commit();
//		System.out.println("Record inserted successfully");
		
//		// Delete Operation 
//		Employee emp = session.get(Employee.class, 2);//1st parameter class reference , 2nd parameter column value which contains pk
//		if(emp==null) {
//			System.out.println("Record not found");
//		}else {
//			tran.begin();
//				session.delete(emp);  // delete query : delete from employee where id = 1
//			tran.commit();
//			System.out.println("Record deleted successfully");
//		}
		
		// Update Query 
//		Employee emp = session.get(Employee.class, 1);//1st parameter class reference , 2nd parameter column value which contains pk
//		if(emp==null) {
//			System.out.println("Record not found");
//		}else {
//			tran.begin();
//				emp.setSalary(20000);
//				session.update(emp);		// update employee set salary = 20000 where id =3
//			tran.commit();
//			System.out.println("Record updated successfully");
//		}
		
		// Retrieve only one record 
//		Employee emp = session.get(Employee.class, 3);// select * from employee where id = 2
//		if(emp==null) {
//			System.out.println("Record not found");
//		}else {
//			//System.out.println(emp);  		// toString();
//			System.out.println("name is "+emp.getName()+" Salary is "+emp.getSalary());
//		}
		
		// Retrieve all or more than one records 
		
		Query qry= session.createQuery("select emp from Employee emp");
		List<Employee> listOfEmp = qry.list();
		System.out.println("Number of records are "+listOfEmp.size());
		Iterator<Employee> li  = listOfEmp.iterator();
		while(li.hasNext()) {
			Employee emp = li.next();
			System.out.println(emp);
		}
		
	}

}
