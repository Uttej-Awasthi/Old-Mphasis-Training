class Car {
	Car() {
		System.out.println("Car class memory created...");
	}
	void displayCarDetails() {
		System.out.println("Car Details method");	
	}
}
class CarTest {
	public static void main(String args[]) {
	Car innova = new Car();	
	innova.displayCarDetails();
	}
}