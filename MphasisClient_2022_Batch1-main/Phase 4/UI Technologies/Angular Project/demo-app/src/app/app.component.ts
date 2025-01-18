import { Component } from '@angular/core';    // inside this file @Component decorator rules written. 

@Component({
  selector: 'app-root',           // <app-root></app-root>
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  name:string ="Akash Kale";

}
