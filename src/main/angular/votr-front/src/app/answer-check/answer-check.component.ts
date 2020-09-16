import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Data, Router} from "@angular/router";

@Component({
  selector: 'app-answer-check',
  templateUrl: './answer-check.component.html',
  styleUrls: ['./answer-check.component.css']
})
export class AnswerCheckComponent implements OnInit {

  token: String;


  constructor(private http:HttpClient, private router: Router) {


  }

  ngOnInit(): void {
  }

  search(query: string) {
    this.http.get("http://votr-test.piwowarczyk.ovh/api/v1/votes/" + this.token).subscribe(data=>{
      this.router.navigate(["glosuj"]);
    })
    //TODO zapytanie do survey voteendpoint
  }
}


