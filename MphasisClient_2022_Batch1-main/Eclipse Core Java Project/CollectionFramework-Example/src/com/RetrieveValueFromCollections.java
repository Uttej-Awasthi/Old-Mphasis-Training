package com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class RetrieveValueFromCollections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// we can use enhaced loop and iterator with Set API 
		Set<String> ss = new HashSet<>();
		ss.add("Ravi"); ss.add("Ramesh"); ss.add("Lokesh"); ss.add("Ajay");
		System.out.println(ss);
		System.out.println("using for each loop");
		for(String str:ss) {
			System.out.println(str);
		}
		System.out.println("Using iterator interface");
		Iterator<String> li	= ss.iterator();
		while(li.hasNext()) {
			String name = li.next();		
			System.out.println(name);
		}
		// we can use enhaced loop and iterator as well as listiterator with List API 
		List<String> ll = new ArrayList<>();
		ll.add("Ravi"); ll.add("Ramesh"); ll.add("Lokesh"); ll.add("Ajay");
		System.out.println("list iterator with forward direction");
		ListIterator<String> li1 = ll.listIterator();
		while(li1.hasNext()) {
			String name = li1.next();
			System.out.println(name);
		}
		System.out.println("list iterator with backward direction");
		while(li1.hasPrevious()) {
			String name= li1.previous();
			System.out.println(name);
		}
	}

}
