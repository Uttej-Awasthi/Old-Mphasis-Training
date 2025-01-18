package com;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Trainer {
@Id
private int tid;
private String tname;
private String tech;
						// CascadeType.ALL we can do all operation 
						// on Student object ie insert, delete, update and retrieve 
						// Trainer object. 
@OneToMany(mappedBy = "tsid",cascade = CascadeType.ALL)				// FK in Student relation 
private List<Student> listOfStudent;
public int getTid() {
	return tid;
}
public void setTid(int tid) {
	this.tid = tid;
}
public String getTname() {
	return tname;
}
public void setTname(String tname) {
	this.tname = tname;
}
public String getTech() {
	return tech;
}
public void setTech(String tech) {
	this.tech = tech;
}
public List<Student> getListOfStudent() {
	return listOfStudent;
}
public void setListOfStudent(List<Student> listOfStudent) {
	this.listOfStudent = listOfStudent;
}
@Override
public String toString() {
	return "Trainer [tid=" + tid + ", tname=" + tname + ", tech=" + tech + ", listOfStudent=" + listOfStudent + "]";
}
public Trainer(int tid, String tname, String tech, List<Student> listOfStudent) {
	super();
	this.tid = tid;
	this.tname = tname;
	this.tech = tech;
	this.listOfStudent = listOfStudent;
}
public Trainer() {
	super();
	// TODO Auto-generated constructor stub
}

}
