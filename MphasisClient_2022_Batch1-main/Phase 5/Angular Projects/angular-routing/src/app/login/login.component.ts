import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginRef = new FormGroup({
    user:new FormControl(),
    pass:new FormControl()
  });

  msg:string=""
  constructor(public router:Router) { } // DI for Router API 

  ngOnInit(): void {
  }

  checkUser(){
    let login = this.loginRef.value;
    if(login.user == "Raj" && login.pass=="123"){   //we can check these details from backend technologies
        sessionStorage.setItem("user","Raj");   // we can set different value if check from backend technologies. 
        this.router.navigate(["home"],{skipLocationChange:true})
    }else {
      this.msg = "Failure try once again"
    }
    this.loginRef.reset();
  }
}
