import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee.model';

@Component({
  selector: 'app-structure-directive',
  templateUrl: './structure-directive.component.html',
  styleUrls: ['./structure-directive.component.css']
})
export class StructureDirectiveComponent implements OnInit {
  f1:boolean =true;
  f2:boolean = false;
  f3:boolean = false;
  flag : boolean = false;
  b1:string ="Show";
  stdNames:Array<string>=["Ravi","Rajesh","Ajay","Vijay","Kumar","Lokesh"];
  employees:Array<Employee>=[];     // this is use to store more than one employee class object. 
  constructor() { }

  ngOnInit(): void {      // life cycle method of component automatically get call only once. 
    let emp1 = new Employee(1,"Ravi",21);
    let emp2 = new Employee(2,"Raju",25);
    let emp3 = new Employee(3,"Ajay",34);
    let emp4 = new Employee(4,"Mahesh",32);
    this.employees.push(emp1);
    this.employees.push(emp2);
    this.employees.push(emp3);
    this.employees.push(emp4);
  }

  changeF3Value() {
    this.f3=true;
  }
  toggle() {
    if(this.b1=="Show"){
        this.b1 = "Hide";
        this.flag=true;
    }else {
      this.b1 = "Show";
      this.flag=false;
    }
  }
}
