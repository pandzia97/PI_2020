import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-answer-check',
  templateUrl: './answer-check.component.html',
  styleUrls: ['./answer-check.component.css']
})
export class AnswerCheckComponent implements OnInit {

  token: String;

  constructor() { }

  ngOnInit(): void {
  }

  search(query: string) {
    //TODO zapytanie do survey voteendpoint
  }
}
