package com;

public class StringDemo {
	public static void main(String[] args) {
//	String str1 = "Welcome to Java";
//	String str2 = new String("Welcome to Java");
//	System.out.println(str1);
//	System.out.println(str2);
//	System.out.println(str1.length());
//	System.out.println(str1.toLowerCase());
//	System.out.println(str1.toUpperCase());
//	System.out.println(str1.substring(3));		// start from 0 position 
//	System.out.println(str1.substring(2,4));	// start from 0 postion 2nd parameter size -1
//	//System.out.println(str1.sub);
//	System.out.println(str1.indexOf("e"));			// from left to right e index position 
//	System.out.println(str1.lastIndexOf("o"));	// right to left o index position
		
//				String str1 = "Raj";
//		String str2 = "Raj";					// string pooling 
//					String str3 = new String("Raj");
//		String str4 = new String("Raj");
//		if(str3.equals(str4)) {
//			System.out.println("Equal");
//		}else {
//			System.out.println("Not Equal");
//		}
		String str = "Raj";
		System.out.println(str);
		str = str +" Deep";
		System.out.println(str);
					System.out.println(str.toLowerCase());
		System.out.println(str);
		
		StringBuffer sb = new StringBuffer("Ajay");
		System.out.println(sb);
				System.out.println(sb.append(" Kumar"));
				sb.reverse();
		System.out.println(sb);
		
	}
}
