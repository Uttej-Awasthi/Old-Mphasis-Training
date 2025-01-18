package com;
abstract class Bike {
	int wheel;
	Bike() {}
	abstract void speed();
}
abstract class Honda extends Bike {
	
	void color() {
		System.out.println("Black");
	}
}
class SuperHonda extends Honda {
	void speed() {
		System.out.println("90km/hr");
	}
}
public class DemoTest {
	public static void main(String[] args) {
//	Honda hh = new Honda();
//	hh.color();
//	hh.speed();
	}

}
