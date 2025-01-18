
export class MyService {

    checkUser(login:any):string {
        
        if(login.user=="Raj" && login.pass=="123"){
            return "succcessfully login"
        }else {
            return "failure try once again";
        }
    }
}