import {Component, Input, OnInit} from '@angular/core';
import {Answer} from "../answer/answer";
import {HttpClient, HttpRequest} from "@angular/common/http";
import {Question} from "../question/question";
import {Option} from "../option/option";

@Component({
  selector: 'app-survey-result',
  templateUrl: './survey-result.component.html',
  styleUrls: ['./survey-result.component.css']
})
export class SurveyResultComponent implements OnInit {
  @Input("surveyId")
  public surveyId: number;
  private answers: Array<Answer>;
  public surveyResult: Map<Question, Array<Map<Option, number>>>;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.http.get("http://votr-test.piwowarczyk.ovh/api/votes/survey/" + this.surveyId).subscribe(data => {
      this.answers = data as Array<Answer>;
      if(this.answers.length!=0) {
        for(let answer of this.answers) {

        }
      }
    });
  }

}
