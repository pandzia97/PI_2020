import { Component, OnInit } from '@angular/core';
import {Survey} from "../survey/survey";

@Component({
  selector: 'app-survey-list-element',
  templateUrl: './survey-list-element.component.html',
  styleUrls: ['./survey-list-element.component.css']
})
export class SurveyListElementComponent implements OnInit {

  survey: Survey;

  constructor() { }

  ngOnInit(): void {
  }

}
