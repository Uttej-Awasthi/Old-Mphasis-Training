import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { LoginService } from '../login.service';
import { MyService } from '../my.service';

@Component({
  selector: 'app-mdf-login-page',
  templateUrl: './mdf-login-page.component.html',
  styleUrls: ['./mdf-login-page.component.css']
})
export class MdfLoginPageComponent implements OnInit {
  loginRef = new FormGroup({
    user : new FormControl(),
    pass : new FormControl()
  });
  msg:string ="";
  constructor(public loginSer:LoginService) { }   // do DI  or pull service class object. 
  ngOnInit(): void {
  }
  checkUser() {
    let login = this.loginRef.value;
    // if(login.user=="Raj" && login.pass=="123"){
    //     this.msg ="Successfully login";
    // }else {
    //     this.msg = "Failure try once again";
    // }
    //let myService = new MyService();
    //this.msg = myService.checkUser(login);
    this.msg = this.loginSer.checkUser(login);
    this.loginRef.reset();
  }

}
