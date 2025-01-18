package abc;

public class Developer extends Employee{

	public void disDevInfo() {
		//System.out.println("a "+a);			// a is private 
		System.out.println("b "+b);
		System.out.println("c "+c);
		System.out.println("d "+d);
	}
}
