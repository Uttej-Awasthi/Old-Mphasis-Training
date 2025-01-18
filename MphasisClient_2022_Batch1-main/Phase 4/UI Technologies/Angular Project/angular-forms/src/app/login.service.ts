import { Injectable } from "@angular/core";


@Injectable()
export class LoginService {
    checkUser(login:any):string {
        
        if(login.user=="Raj" && login.pass=="123"){
            return "succcessfully login"
        }else {
            return "failure try once again";
        }
    }
}