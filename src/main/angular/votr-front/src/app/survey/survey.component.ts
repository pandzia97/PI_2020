import {Component, OnInit} from '@angular/core';
import {Survey} from "./survey";
import { faCheck, faTimes, faEdit } from '@fortawesome/free-solid-svg-icons';
import {Question} from "../question/question";

import {HttpClient, HttpHandler, HttpHeaders} from "@angular/common/http";


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




  constructor(  private http: HttpClient) {


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

    console.log(JSON.stringify(this.survey) );
    this.http.post<Survey>("http://votr-test.piwowarczyk.ovh/api/v1/surveys",JSON.stringify(this.survey),{
      headers : new HttpHeaders({ 'Content-Type': 'application/json' })}
  ).subscribe(data => {
      console.log(data);
    });

  }

  resetSurvey() {
    this.survey = new Survey();
  }


}

