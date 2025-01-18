package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bean.Employee;

@Repository
public class EmployeeDao {

	@Autowired
	SessionFactory sf;
	
	public int storeEmployee(Employee emp) {
			try {
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
}
