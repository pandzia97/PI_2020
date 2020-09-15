import {Component, OnInit} from '@angular/core';
import {Vote} from "./vote";
import {Survey} from "../survey/survey";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {ActivatedRoute} from "@angular/router";
import {Answer} from "../answer/answer";

@Component({
  selector: 'app-vote',
  templateUrl: './vote.component.html',
  styleUrls: ['./vote.component.css']
})
export class VoteComponent implements OnInit {

  vote: Vote;
  private surveyId: number;


  constructor(private http:HttpClient, private route:ActivatedRoute) {

  }

  ngOnInit(): void {
    this.route.params.subscribe(params=>this.surveyId = params["id"]);
    this.vote = new Vote();
    this.http.get("http://votr-test.piwowarczyk.ovh/api/v1/surveys/" + this.surveyId).subscribe(data=>{
    this.vote.survey = data as Survey;
      for(let question of this.vote.survey.questions) {
        let answer = new Answer();
        answer.question = question;
        this.vote.answers.push(answer);
      }
    })

  }

  sendVote() {

    this.http.post("http://votr-test.piwowarczyk.ovh/api/v1/votes", JSON.stringify(this.vote),{
      headers : new HttpHeaders({ 'Content-Type': 'application/json' })}
  ).subscribe(data => {
      console.log("recevid data: " + data);
    });
  }
}
