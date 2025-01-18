package com;

import java.util.ArrayList;
import java.util.List;

public class CollectionWithGenerics {

	public static void main(String[] args) {
//		// ll allow to store any types of values. 
//		List ll = new ArrayList();
//		ll.add(10);
//					ll.add(10.20);
//		ll.add("Ravi");
//		ll.add(true);
//		Object obj	 = ll.get(1);
//		Integer i = (Integer)obj;
//		int n = i.intValue();
//		System.out.println(n);
		// Collection Framework with Generics 
		
		List<Integer> ll = new ArrayList<Integer>();
		ll.add(10);				// auto boxing :converting primitive to object. 
		ll.add(20);
		ll.add(30);
		int n	= ll.get(0);					// auto-unboxing : converting object to primitive 
		System.out.println(n);
	}

}
