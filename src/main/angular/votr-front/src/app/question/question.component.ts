import {Component, Input, OnInit} from '@angular/core';
import {Question} from "./question";
import {Option} from "../option/option";
import {faEdit} from "@fortawesome/free-solid-svg-icons/faEdit";
import {faCheck} from "@fortawesome/free-solid-svg-icons/faCheck";
import {faTimes} from "@fortawesome/free-solid-svg-icons/faTimes";



@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css']
})
export class QuestionComponent implements OnInit {

  @Input('question')
  public question: Question;
  public editEnabled: boolean = true;
  faEdit = faEdit;
  faCheck = faCheck;
  faTimes = faTimes;




  constructor() {
  }

  ngOnInit(): void {
  }

  enableEdit(){
      if (this.editEnabled == false) {
        this.editEnabled = true;

      }
  }

  accept(newValue: String) {
    if (this.editEnabled == true) {
      this.question.value = newValue;
      this.editEnabled = false;

    }
  }

  discard() {
    if (this.editEnabled == true) {
      this.editEnabled = false;
    }

  }

  addNewAnswer() {
    let answer = new Option();
    this.question.answers.push(answer);

  }
}

