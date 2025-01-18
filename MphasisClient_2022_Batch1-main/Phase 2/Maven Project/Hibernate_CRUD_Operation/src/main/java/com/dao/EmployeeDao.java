package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bean.Employee;
import com.resource.DbResource;

public class EmployeeDao {

	public List<Employee> getAllEmployee() {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		Query qry = session.createQuery("select emp from Employee emp");
		List<Employee> listOfEmp = qry.list();
		return listOfEmp;
	}
	
	public int storeEmployee(Employee emp) {
		try {
			SessionFactory sf = DbResource.getSessionFactory();
			Session session = sf.openSession();
			Transaction tran = session.getTransaction();
			tran.begin();
					session.save(emp);
			tran.commit();
			return 1;
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	public int deleteEmployee(int id) {
			SessionFactory sf = DbResource.getSessionFactory();
			Session session = sf.openSession();
			Transaction tran = session.getTransaction();
			Employee emp = session.get(Employee.class, id);	// select * from employee where id =1
			if(emp==null) {
				return 0;
			}else {
				tran.begin();
						session.delete(emp);
				tran.commit();
				return 1;
			}	
	}
	public int updatemployee(Employee e) {
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.getTransaction();
		Employee emp = session.get(Employee.class, e.getId());
		if(emp==null) {
			return 0;
		}else {
			tran.begin();
					emp.setSalary(e.getSalary());					// replace the old salary by new salary 
					//emp.setSalary(emp.getSalary()+e.getSalary());	// increment the salary by new amount 
					session.update(emp);
			tran.commit();
			return 1;
		}
	
	}
	
	public List<Employee> findBySalary(float salary){
		SessionFactory sf = DbResource.getSessionFactory();
		Session session = sf.openSession();
		Query qry = session.createQuery("select emp from Employee emp where emp.salary > :sal ");
		qry.setParameter("sal", salary);
		List<Employee> listOfEmp = qry.list();
		return listOfEmp;
	}
	
	
}
