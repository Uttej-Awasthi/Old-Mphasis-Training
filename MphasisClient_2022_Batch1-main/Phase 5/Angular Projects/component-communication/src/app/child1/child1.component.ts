import { Component, Input, OnInit } from '@angular/core';
import { SharedService } from '../shared.service';

@Component({
  selector: 'app-child1',
  templateUrl: './child1.component.html',
  styleUrls: ['./child1.component.css']
})
export class Child1Component implements OnInit {

  @Input()
  pName:string="";    // this variable is ready to receive the value from parent component 
  
  studentNames:Array<string>=["Raj","Ravi","Ramesh","Rajesh"];

  childAge:number = 21;
  
  constructor(public ss:SharedService) { }    // DI for Shared Service class

  ngOnInit(): void {
    this.ss.setNames(this.studentNames);    // set names in shared service class. 
  }

}
