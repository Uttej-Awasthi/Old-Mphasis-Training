package com;
class A {
		int x=100;
}
class B extends A {
		int x=200;
		void dis1() {
			int x = 300;
			System.out.println("x local variable "+x);
			System.out.println("x instance variable "+this.x);
			System.out.println("x super class variable "+super.x);
		}
}
public class DemoTest {
	public static void main(String[] args) {
		B obj = new B();
		obj.dis1();
	}
}
