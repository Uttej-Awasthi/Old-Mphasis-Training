import { Component, OnInit } from '@angular/core';
import { Exam } from '../exam';
import { ExamService } from '../exam.service';

@Component({
  selector: 'app-exam',
  templateUrl: './exam.component.html',
  styleUrls: ['./exam.component.css']
})
export class ExamComponent implements OnInit {

  questionData:Array<Exam>=[];
  constructor(public ser:ExamService) { }   // DI for Service class. 

  ngOnInit(): void {
  }

  start() {
      this.ser.loadJsonData().subscribe(data=>this.questionData=data)
  }

  
}
