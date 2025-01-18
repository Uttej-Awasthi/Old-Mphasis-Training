package abc;
class A {
	void dis1() {
		System.out.println(" A class own dis1 method");
	}
}
class B extends A{
	void dis1() {
		System.out.println(" B class override dis1 method");
	}
	void dis2() {
		System.out.println(" B class own dis2 method");
	}
}
public class DemoTest1 {
	public static void main(String[] args) {
//	B obj = new B();
//	obj.dis1();
//	A obj1 = new A();		obj1.dis1(); //obj1.dis2()
//	B obj2 = new B();		obj2.dis1(); 	obj2.dis2();
		A obj3 = new B();	// sub class object super class reference : it is possible 
//	// with help of super class refeference we can call only those methods which belong 
//	// super class or overrided methods. 
		obj3.dis1();
//	//obj3.dis2();
//	//B obj4 = new A();	// super class object sub class refeference not possible 
	}
}
