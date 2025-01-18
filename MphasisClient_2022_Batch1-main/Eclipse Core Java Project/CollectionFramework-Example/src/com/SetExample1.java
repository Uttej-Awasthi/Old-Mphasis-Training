package com;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
public class SetExample1 {
	public static void main(String[] args) {
	//	Set ss = new HashSet();
	//	Set ss = new LinkedHashSet();
		Set ss = new TreeSet();
		System.out.println("Size "+ss.size());
		System.out.println("Empty "+ss.isEmpty());
		ss.add(10);
		ss.add(10);
		ss.add(20);
		ss.add(15);
		ss.add(12);
		ss.add(18);
		//ss.add(16.50);
		System.out.println("Size "+ss.size());
		System.out.println("Empty "+ss.isEmpty());
		System.out.println(ss);
		System.out.println("remove "+ss.remove(12));
		System.out.println("remove "+ss.remove(100));
		System.out.println(ss);
		System.out.println("Search "+ss.contains(10));
		System.out.println("Search "+ss.contains(100));
		ss.clear();
		System.out.println("Size "+ss.size());
		System.out.println("Empty "+ss.isEmpty());
	}

}
