package com;
class Bike {
	void speed() {
		System.out.println("60km/hr");
	}
}
class Honda extends Bike {						// re-usability of speed();
	void color() {
		System.out.println("Gray");
	}
}
class Pulsar extends Bike {
	void speed() {									// this class override speed method 
		System.out.println("90km/hr");
	}
	void color() {
		System.out.println("Black");
	}
}
class Tvs extends Bike {
	void color() {
		System.out.println("Red");
	}
	void speed() {
		super.speed();						// the code present in super class +
		//speed();			// same class speed method called.. 
		System.out.println("10km/hr");			// sub class merge 
	}
}
public class MethodOverridingTest {
	public static void main(String[] args) {
		Honda hh = new Honda();						hh.speed();     hh.color();
		Pulsar pu = new Pulsar();                      pu.speed();     pu.color();
		Tvs tv = new Tvs();								tv.speed();     tv.color();					
	}
}
