package xyz;

interface A {
	void dis1();
}
class B implements A{
	public void dis1() {
		System.out.println(" B class override dis1 method");
	}
	void dis2() {
		System.out.println(" B class own dis2 method");
	}
}
public class DemoTest1 {
	public static void main(String[] args) {
		//A obj1 = new A();
		//B obj2 = new B();		obj2.dis1();  obj2.dis2();
		A obj3  = new B();		// creating object of sub class object which is normal class and creating reference of super class 
							// it can be normal class as well as interface
		obj3.dis1();				// obj2.dis2();
	}
}
