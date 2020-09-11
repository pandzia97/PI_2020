import {Component, OnInit} from '@angular/core';
import {Survey} from "./survey";
import { faCheck, faTimes, faEdit } from '@fortawesome/free-solid-svg-icons';
import {Question} from "../question/question";

@Component({
  selector: 'app-survey',
  templateUrl: './survey.component.html',
  styleUrls: ['./survey.component.css']
})
export class SurveyComponent implements OnInit {

  faCheck = faCheck;
  faTimes = faTimes;
  faEdit = faEdit;
  public survey: Survey;
  public editEnabled: boolean;

  constructor() {
    this.survey = new Survey();
    this.editEnabled = true;
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
      this.survey.name = newValue;
      this.editEnabled = false;

    }
  }

  discard() {
    if (this.editEnabled == true) {
      this.editEnabled = false;
    }
  }

  addNewQuestion() {
    let question = new Question();
    this.survey.questions.push(question);
  }

  saveSurvey(){
    //TODO implementacja requestu do API
  }

  resetSurvey() {
    this.survey = new Survey();
  }


}

