import { AfterViewInit, Component, ViewChild } from '@angular/core';
import { Child1Component } from './child1/child1.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements AfterViewInit{
  parentName:string = "Raj Patil";

  cAge:number=0;     // parent component 

  @ViewChild(Child1Component)     // DI for child1 component 
  childRef?:Child1Component;    // optional rference. 

  ngAfterViewInit(): void {
     
      if(this.childRef!=null){
          this.cAge=this.childRef.childAge;
      }
    
  } 
}
