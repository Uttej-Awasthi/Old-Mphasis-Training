package com;
final class A {
		int a=10;
		final int B=20;
		final void dis1() {
			a=20;
			//B=30;
			System.out.println(" A class method");
		}
}
//class B extends A{
////		void dis1() {
////			System.out.println("Method override");
////		}
//}
public class DemoTest {
	public static void main(String[] args) {
//		B obj = new B();
//		obj.dis1();
		A obj = new A();
		obj.dis1();
	}
}
