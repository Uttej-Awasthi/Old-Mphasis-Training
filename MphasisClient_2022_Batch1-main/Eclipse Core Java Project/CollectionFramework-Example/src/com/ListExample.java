package com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ListExample {

	public static void main(String[] args) {
//		Stack ss = new Stack();
//		ss.push(100);
//		ss.push(200);
//		ss.push(300);
//		System.out.println(ss);
//		System.out.println(" top most remove "+ss.pop());		// remove from stack 
//		System.out.println(ss);	
//		System.out.println("only view top most element "+ss.peek()); // it only retrieve 
//		System.out.println(ss);
	
//		List ll = new ArrayList();
//		ll.add(10);
//		ll.add(20.20);
//		ll.add(30);
//		ll.add(40);
//		System.out.println("All elements "+ll);
//		System.out.println("get element using index position "+ll.get(1));
//								ll.add(1, 200);
//		System.out.println("get element using index position "+ll.get(1));
//		ll.remove(1);				// remove using index position 
//		ll.remove(new Integer(10));			// remove using value 
//		System.out.println(ll);
//		System.out.println(" Search "+ll.contains(40));
//		System.out.println("Search "+ll.contains(100));
		
		List ll = new LinkedList();
						ll.add(10);
							ll.add(20);
						ll.add(30);
		ll.add(40);
		ll.add(50);
		ll.add(60);
		
		ll.add(1, 100);
		
	}

}
