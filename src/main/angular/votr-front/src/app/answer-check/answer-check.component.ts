import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-answer-check',
  templateUrl: './answer-check.component.html',
  styleUrls: ['./answer-check.component.css']
})
export class AnswerCheckComponent implements OnInit {

  token: String;

  constructor(private http: HttpClient, private router: Router) {
  }

  ngOnInit(): void {
    this.token = "";
  }

  search(query: string) {
    this.token = query;

    if (query.length!=0) {
      this.router.navigate(["sprawdz", this.token]);
    }

  }
}


