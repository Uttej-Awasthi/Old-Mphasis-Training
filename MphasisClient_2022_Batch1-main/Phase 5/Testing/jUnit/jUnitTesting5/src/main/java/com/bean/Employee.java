package com.bean;

public class Employee {
private int id;
private String name;
private float salary;
private String desg;

public Employee(int id, String name, float salary, String desg) {
	super();
	this.id = id;
	this.name = name;
	this.salary = salary;
	this.desg = desg;
}
@Override
public String toString() {
	return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", desg=" + desg + "]";
}
public String getDesg() {
	return desg;
}
public void setDesg(String desg) {
	this.desg = desg;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public float getSalary() {
	return salary;
}
public void setSalary(float salary) {
	this.salary = salary;
}
public Employee() {
	super();
	// TODO Auto-generated constructor stub
}

}
