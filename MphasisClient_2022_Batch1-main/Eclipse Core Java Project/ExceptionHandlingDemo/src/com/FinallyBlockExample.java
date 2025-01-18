package com;

public class FinallyBlockExample {

	public static void main(String[] args) {
	// try with catch and finally 
//		try {
//			int a=10/0;
//			System.out.println("No Exception");
//		}catch (Exception e) {
//			System.out.println("Catch block");
//		}finally {
//			System.out.println("Finally block");
//		}
//		System.out.println("Normal statement");
		
		// try with finally 
		try {
			int a=10/0;
			System.out.println("No Exception");
		}finally {
			System.out.println("Finally block");
		}
		System.out.println("Normal statement");
	}

}
