import {Component, Input, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Question} from "../question/question";
import {Option} from "../option/option";
import {Vote} from "../vote/vote";

@Component({
  selector: 'app-survey-result',
  templateUrl: './survey-result.component.html',
  styleUrls: ['./survey-result.component.css']
})
export class SurveyResultComponent implements OnInit {
  @Input("surveyId")
  public surveyId: number;
  private votes: Array<Vote>;
  // public surveyResult: Map<Question, Map<Option, number>>;
  public surveyResult: Map<String, Map<String, number>>;

  constructor(private http: HttpClient) {

  }

  ngOnInit(): void {
    this.http.get("http://votr-test.piwowarczyk.ovh/api/v1/votes/survey/" + this.surveyId).subscribe(data => {
      this.votes = data as Array<Vote>;
      if (this.votes.length != 0) {
        for (let vote of this.votes) {
          for (let answer of vote.answers) {

            if (!this.surveyResult) {
              this.surveyResult = new Map<String, Map<String, number>>();
            }
            if (!this.surveyResult.has(JSON.stringify(answer.question))) {

              this.surveyResult.set(JSON.stringify(answer.question), new Map<String, number>());
              for (let option of answer.question.options) {
                this.surveyResult.get(JSON.stringify(answer.question)).set(JSON.stringify(option), 0);
              }
            }
            let votesCount = this.surveyResult.get(JSON.stringify(answer.question)).get(JSON.stringify(answer.option)) as number;
            votesCount += 1;
            this.surveyResult.get(JSON.stringify(answer.question)).set(JSON.stringify(answer.option), votesCount);

          }
        }
      }

    });

  }
}
