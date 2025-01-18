import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { LoginService } from '../login.service';
import { MyService } from '../my.service';
@Component({
  selector: 'app-tdf-login-page',
  templateUrl: './tdf-login-page.component.html',
  styleUrls: ['./tdf-login-page.component.css']
})
export class TdfLoginPageComponent implements OnInit {
  msg:string="";
  constructor(public loginService:LoginService) { }   // pull object or DI for service clas 
  ngOnInit(): void {
  }
  checkUser(loginRef:NgForm){
    //alert("submit event fired..")
    let login = loginRef.value;
    //alert(login);
    // console.log(login);
    // if(login.user=="Raj" && login.pass=="123"){
    //     this.msg="successfully login!";
    // }else {
    //     this.msg = "Failure try once again";
    // }
    // let myService = new MyService();
    // this.msg = myService.checkUser(login);
    this.msg = this.loginService.checkUser(login);
    loginRef.reset();
  }
}
