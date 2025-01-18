package com;

import java.io.DataInputStream;
import java.io.PrintStream;

public class BytewiseOperation {
	public static void main(String[] args) throws Exception{
		DataInputStream dis = new DataInputStream(System.in);
		PrintStream ps = System.out;
		ps.println("Enter the name");
		String name  = dis.readLine();
		ps.println("Your name is "+name);
	}
}
