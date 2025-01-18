package com;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class DemoTest {

	public static void main(String[] args) {
		//Employee emp = new Employee();
		//emp.display();
		//Resource res = new ClassPathResource("beans.xml"); // file load reference of this class 
														// Resource interface . 
		//BeanFactory bean = new XmlBeanFactory(res);	// BeanFactory is a interface 
													// that interface implementation class 
													// is XmlBeanFactory
		BeanFactory bean = new XmlBeanFactory(new ClassPathResource("beans.xml"));
		
//		Employee e1 = (Employee)bean.getBean("emp1");
//		e1.display();
//		
//		Employee ee1 = (Employee)bean.getBean("emp1");
//		ee1.display();
//		
//		Employee e2 = (Employee)bean.getBean("emp2");
//		e2.display();
//		
//		Employee ee2 = (Employee)bean.getBean("emp2");
//		ee2.display();
		
//		Employee e1 = (Employee)bean.getBean("emp1");
//		System.out.println(e1);			// it will call toString() method. 
//		Employee e2 = (Employee)bean.getBean("emp2");
//		System.out.println(e2);			// it will call toString() method.
//		
//		Employee e3 = (Employee)bean.getBean("emp3");
//		System.out.println(e3);			// it will call toString() method. 
//		
//		Employee e4 = (Employee)bean.getBean("emp4");
//		System.out.println(e4);			// it will call toString() method. 
//		
//		Employee e5 = (Employee)bean.getBean("emp5");
//		System.out.println(e5);	
		
		Employee emp = (Employee)bean.getBean("employee");
		System.out.println(emp);
	}
	

}
