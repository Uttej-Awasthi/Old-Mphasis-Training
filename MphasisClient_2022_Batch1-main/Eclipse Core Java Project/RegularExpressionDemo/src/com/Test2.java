package com;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {
	public static void main(String[] args) {
		String str = "Welcome to Java Training Provided by Simplilearn";
		//Pattern pt  = Pattern.compile("a");		// search a character
		Pattern pt  = Pattern.compile("Java");		// search a character
		Matcher mt  = pt.matcher(str);
		while(mt.find()) {
			//System.out.println("Yes");
			System.out.println("Start "+mt.start());
			System.out.println("End "+mt.end());		
		}
	}
}
