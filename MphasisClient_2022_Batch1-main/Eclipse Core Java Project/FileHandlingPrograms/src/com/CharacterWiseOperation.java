package com;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CharacterWiseOperation {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//InputStreamReader isr = new InputStreamReader(System.in);
		//BufferedReader br = new BufferedReader(isr);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the id");
		int id = Integer.parseInt(br.readLine());		// convet string to integer 
		System.out.println("Enter the name");
		String name = br.readLine();
		System.out.println("Your id is "+id);
		System.out.println("your name is "+name);
	}

}
