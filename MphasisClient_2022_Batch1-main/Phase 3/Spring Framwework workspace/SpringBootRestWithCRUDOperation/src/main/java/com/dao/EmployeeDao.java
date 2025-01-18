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

	@Autowired
	EntityManagerFactory emf;
	
	public List<Employee> getAllEmployee() {
		EntityManager manager  = emf.createEntityManager();
		Query qry = manager.createQuery("select emp from Employee emp");
		List<Employee> listOfEmp = qry.getResultList();
		return listOfEmp;
	}
	
	public int storeEmployee(Employee emp) {
		try {
			EntityManager manager = emf.createEntityManager();
			EntityTransaction tran = manager.getTransaction();
			tran.begin();
				manager.persist(emp);
			tran.commit();
			return 1;
		} catch (Exception e) {
			System.out.println(e);
		}
		return 1;
	}
	public int updateEmployee(Employee emp) {
		
			EntityManager manager = emf.createEntityManager();
			EntityTransaction tran = manager.getTransaction();
			Employee e = manager.find(Employee.class, emp.getId());
			if(e==null) {
				return 0;
			}else {
				tran.begin();
				e.setSalary(emp.getSalary());
				manager.merge(e);				// update the record. 
				tran.commit();
				return 1;
			}
	}
	public int deleteEmployee(int id) {
		
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tran = manager.getTransaction();
		Employee e = manager.find(Employee.class, id);
		if(e==null) {
			return 0;
		}else {
			tran.begin();
			manager.remove(e);
			tran.commit();
			return 1;
		}
}
}
