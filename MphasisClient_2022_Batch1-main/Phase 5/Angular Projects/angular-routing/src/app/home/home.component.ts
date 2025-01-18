import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  user?:string;
  constructor(public router:Router) { }

  ngOnInit(): void {
    //this.activerouter.params.subscribe
    let obj = sessionStorage.getItem("user")
    if(obj!=null){
      this.user=obj;
    }
  }


  logout() {
    this.router.navigate(["login"],{skipLocationChange:true});
  }
}
