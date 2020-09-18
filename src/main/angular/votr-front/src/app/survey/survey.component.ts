import {Component, OnInit} from '@angular/core';
import {Survey} from "./survey";
import {faCheck, faEdit, faTimes} from '@fortawesome/free-solid-svg-icons';
import {Question} from "../question/question";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Router} from "@angular/router";
import {GlobalVariables} from "../common/global-variables";


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

  constructor(private http: HttpClient, private router: Router) {


    this.survey = new Survey();
    this.editEnabled = true;


  }

  ngOnInit(): void {

  }

  enableEdit() {
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

  saveSurvey() {


    this.http.post<Survey>(`${GlobalVariables.apiUrl}/surveys`, JSON.stringify(this.survey), {
        headers: new HttpHeaders({'Content-Type': 'application/json'})
      }
    ).subscribe(data => {
      this.router.navigate(["successful"]);

    });

  }

  resetSurvey() {
    this.survey = new Survey();
  }


}

