package com;

public class TryWithMultipleCatchBlock {

	public static void main(String[] args) {
			int abc[]= {10,20};
			String str = "a10";
		try {
			//int a=10/0;
			//int b=10/abc[3];
			int sum = 10+Integer.parseInt(str);		// convert string to int 
			System.out.println(sum);
		}catch (ArithmeticException | NumberFormatException e) {			// this catch block ready to handle two exception 
			System.out.println("Divided by zero or Number Format");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Array Index");
		}catch (Exception e) {				// it can handle any exception except above 2 
			System.out.println("Generic Exception");
		}
		System.out.println("Finish");
	}

}
