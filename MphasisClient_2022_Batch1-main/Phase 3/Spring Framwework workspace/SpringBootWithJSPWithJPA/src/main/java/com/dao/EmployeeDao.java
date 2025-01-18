package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Employee;

@Repository
public class EmployeeDao {

	@Autowired							// @Autowired 	
	EntityManagerFactory emf;			//@SessionFactory sf
	
	public int storeEmployee(Employee emp) {
		try {
		EntityManager manager = emf.createEntityManager();		// Session session =sf.openSession();
		EntityTransaction tran = manager.getTransaction();		// Transaction tran = session.getTransaction();
		tran.begin();
				manager.persist(emp);                           // session.save(emp);
		tran.commit();
		return 1;
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
	public int updateEmployee(Employee emp) {
		
		EntityManager manager = emf.createEntityManager();		// Session session =sf.openSession();
		EntityTransaction tran = manager.getTransaction();		// Transaction tran = session.getTransaction();
		Employee e= manager.find(Employee.class, emp.getId());		// get() 
		if(e==null) {
			return 0;
		}else {
			tran.begin();
			e.setSalary(emp.getSalary());
			manager.merge(e);                          // session.update(emp);
			tran.commit();
			return 1;
		}	
	}
	public int deleteEmployee(int empId) {
		EntityManager manager = emf.createEntityManager();		// Session session =sf.openSession();
		EntityTransaction tran = manager.getTransaction();		// Transaction tran = session.getTransaction();
		Employee e= manager.find(Employee.class, empId);		// get() 
		if(e==null) {
			return 0;
		}else {
			tran.begin();
			manager.remove(e);                          // session.delete(emp);
			tran.commit();
			return 1;
		}
	}
	
	public List<Employee> getAllEmployee() {
	
	EntityManager manager = emf.createEntityManager();		// Session session =sf.openSession();
		Query qry = manager.createQuery("select emp from Employee emp");
		List<Employee> listOfEmp= qry.getResultList();
		return listOfEmp;	
	}
}



