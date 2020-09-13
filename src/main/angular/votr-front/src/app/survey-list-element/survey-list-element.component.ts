
import {Component, Input, OnInit} from '@angular/core';
import {Survey} from "../survey/survey";
import {Router} from "@angular/router";


@Component({
  selector: 'app-survey-list-element',
  templateUrl: './survey-list-element.component.html',
  styleUrls: ['./survey-list-element.component.css']
})
export class SurveyListElementComponent implements OnInit {

  @Input('survey')
  survey: Survey;

  constructor(private  router: Router) { }


  ngOnInit(): void {
  }


  openSurvey(id: number, mode: String) {
    this.router.navigate(['glosuj', id]);
  }

}
