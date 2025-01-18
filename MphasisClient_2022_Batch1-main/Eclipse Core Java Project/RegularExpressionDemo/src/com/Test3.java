package com;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test3 {

	public static void main(String[] args) {
		//String pattern="[abc]";			// start with a or b or c
		//String pattern="[^abc]";			// not start with a or b or c
		//String pattern ="[a-z]";				// first character must be a to z 
		//String pattern = "[[a-z] || [A-Z]]";		// first character must be a to z or A to Z
		//String pattern = "[a-z,A-Z,0-9]";
		//String pattern = "\\d";			// [0-9]	equal to 0 to 9		[0-9][0-9]
		//String pattern = "\\d{10}";		// valid phone number 
		//String name = "9876543210";
		//String pattern = "\\w{3}\\d";				//[a-z]		: 3 character names must be valid 
		//String name ="Raj1";
		//String pattern ="\\w{2,4}";			//  min 2 and max 4 character 
		//String name = "Raju";
		//String pattern = "[a-z]";			// only one character and mandatory a to z
		//String pattern = "[a-z]?";			// optional 0 to 1
		//String pattern = "[a-z]+";			// 1 to many 
		//String pattern = "[a-z]*";			// o to many 
		//String name = "";
		String pattern ="[a-z]+@[a-z]+\\.com";
	    String name ="a@b.com";
		Pattern pt  = Pattern.compile(pattern);	
		Matcher mt  = pt.matcher(name);		
		if(mt.matches()) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}

	}

}
