import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-event-binding',
  templateUrl: './event-binding.component.html',
  styleUrls: ['./event-binding.component.css']
})
export class EventBindingComponent implements OnInit {
  msg:string ="Hi";
  name:string ="";
  constructor() { }
  ngOnInit(): void {
  }
  fun() {
    //alert("Welcome to event binding in angular");
    this.msg = "hello";
  }
  passValue(nameRef:any){
    this.name = nameRef.value;    // value is property to get the value from reference. 
    nameRef.value=""
  }
}
