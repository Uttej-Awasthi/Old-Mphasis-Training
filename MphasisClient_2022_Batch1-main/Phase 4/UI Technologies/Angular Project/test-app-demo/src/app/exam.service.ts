import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Exam } from './exam';

@Injectable({
  providedIn: 'root'  // providedIn = root is equal to providers attribute in app.module.ts file 
})
export class ExamService {

  constructor(public http:HttpClient) { }   // DI for HttpClient 

  // static file 
  // loadJsonData() : void {
  //   this.http.get("../assets/questions.json").subscribe(data=>console.log(data),
  //                                 error=>console.log(error),
  //                                 ()=>console.log("completed"));
  // }
  // loading data from json server but make sure json server running. 
  // loadJsonData() : void {
  //   this.http.get("http://localhost:3001/questions").subscribe(data=>console.log(data),
  //                                 error=>console.log(error),
  //                                 ()=>console.log("completed"));
  // }
  // please do type case base that type of data retreive. 
  loadJsonData() :Observable<Exam[]> {
    return this.http.get<Exam[]>("http://localhost:3001/questions");
  }
}
