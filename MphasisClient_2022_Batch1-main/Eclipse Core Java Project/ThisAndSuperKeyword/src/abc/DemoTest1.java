package abc;
class Employee {
	public Employee() {
		//this(100);
		System.out.println("it is empty constructor");
	}
	Employee(int id){
		this(101,"Ramesh");
		System.out.println("One parameter constructor");
	}
	Employee(int id, String name){
		this();
		System.out.println("Two parameter constructor");
	}
}
public class DemoTest1 {
	public static void main(String[] args) {
		//Employee emp1 = new Employee();
		Employee emp2 = new Employee(100);
		//Employee emp3 = new Employee(101, "Ramesh");
	}
}
