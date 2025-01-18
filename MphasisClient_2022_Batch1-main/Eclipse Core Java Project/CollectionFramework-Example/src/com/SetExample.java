package com;

import java.util.HashSet;
import java.util.Set;
class A {		}
class B {		}
public class SetExample {

	public static void main(String[] args) {
		//Set ss = new HashSet();
		HashSet ss = new HashSet();
		int a=10;				// primitive consider 
		//Integer b = new Integer(a);		// converting primitive to object. 
		Integer b = 10;			// auto-boxing : literal style. 
		ss.add(b);			
		ss.add(20);		//auto-boxing : converting primitive to Object. 
		ss.add(30.30);
		ss.add("Ramesh");
		ss.add(true);
		A obj1 = new A();
		B obj2 = new B();
		ss.add(obj1);
		ss.add(obj2);
		System.out.println(ss);
	}

}
