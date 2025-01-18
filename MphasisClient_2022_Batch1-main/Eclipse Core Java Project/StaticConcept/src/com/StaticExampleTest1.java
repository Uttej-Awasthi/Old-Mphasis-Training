package com;
class Test {
	int a;
	static int b;
	void dis1() {
		System.out.println("a "+a);
		System.out.println("b "+b);
	}
}
public class StaticExampleTest1 {
	public static void main(String[] args) {
					Test obj1 = new Test();
					Test obj2 = new Test();
									obj1.a=10;
											obj1.b=20;
													Test.b=30;
														obj2.a=40;
														obj2.b=50;
														Test.b=60;
		obj1.dis1();					// a=	10		b =60 
		obj2.dis1();					// a= 40		b= 60
	}

}
