package com;
interface A {
 	int X=10;
 	void dis1();
}
interface B {
	int Y=20;
	void dis2();
}
interface C  extends A,B{		// Multiple inheritance. 
	int Z=30;
	void dis3();	
}
class D implements A,B {
	public void dis1() {
		System.out.println(" A interface method");
	}
	public void dis2() {
		System.out.println("B interface method");
	}
}
public class InterfaceTest {
	public static void main(String[] args) {
		D obj1 = new D();
		obj1.dis1();
		obj1.dis2();
	}
}
