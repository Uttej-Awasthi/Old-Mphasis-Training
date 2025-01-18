package com;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Map mm = new HashMap();
		//Map mm = new LinkedHashMap();
		Map mm = new TreeMap();
		mm.put(2, "Raj");
		mm.put(1, "Ajay");
		mm.put(7, "xyz");
		mm.put(3, "Mahesh");
		System.out.println(mm);
		mm.put(1, "Vijay");
		mm.put(5, "Raj");
		System.out.println(mm);
		if(mm.containsKey(6)) {
			System.out.println("key present");
		}else {
			System.out.println("key not present");
		}
		System.out.println("using key we get the value "+mm.get(1));
		System.out.println("using key we get the value "+mm.get(10));
	}

}
