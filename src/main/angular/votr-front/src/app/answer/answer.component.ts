import {Component, Input, OnInit} from '@angular/core';
import {Answer} from "./answer";
import {Option} from "../option/option";

@Component({
  selector: 'app-answer',
  templateUrl: './answer.component.html',
  styleUrls: ['./answer.component.css']
})
export class AnswerComponent implements OnInit {
  @Input("answer")
  answer: Answer;

  constructor() { }

  ngOnInit(): void {

  }

  updateAnswer() {
    console.log(this.answer.option.value);

  }
}


