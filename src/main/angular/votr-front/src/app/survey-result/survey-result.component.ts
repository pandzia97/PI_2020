import {Component, Input, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Question} from "../question/question";
import {Vote} from "../vote/vote";
import {GlobalVariables} from "../common/global-variables";

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
  JSON = JSON;

  constructor(private http: HttpClient) {

  }

  ngOnInit(): void {
    this.http.get(`${GlobalVariables.apiUrl}/votes/survey/` + this.surveyId).subscribe(data => {
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
    this.surveyResult = this.parse();
    });

  }
  parse() : Map<String, Map<String, number>> {
    let questions = new Map<String, Map<String, number>>();
    this.surveyResult.forEach((value, key) => {
      let parsedQuestion = JSON.parse(key as string);
      let answers = new Map<String, number>();
      value.forEach((value1, key1) => {
        let parsedAnswer = JSON.parse(key1 as string);
        answers.set(parsedAnswer.value, value1);
      });
      questions.set((parsedQuestion as Question).question, answers)
    });
    return questions;
  }
}
