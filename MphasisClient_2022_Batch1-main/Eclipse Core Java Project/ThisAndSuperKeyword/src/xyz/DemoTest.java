package xyz;
class Employee {
	public Employee() {
		System.out.println("Employee class object created...");
	}
	public Employee(int x) {
		this();
		System.out.println(" Employee one parameter constructor");
	}
}
class Manager extends Employee {
	public Manager() {
		super(100);				// which is responsible to call super class empty constructor. 
		System.out.println("Manager class object created...");
	}
}
public class DemoTest {
	public static void main(String[] args) {
		Manager mgr = new Manager();
	}
}
