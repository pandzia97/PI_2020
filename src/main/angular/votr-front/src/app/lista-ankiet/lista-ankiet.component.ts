import { Component, OnInit } from '@angular/core';
import {Survey} from "../survey/survey";
import {SurveyListElementComponent} from "../survey-list-element/survey-list-element.component";

@Component({
  selector: 'app-lista-ankiet',
  templateUrl: './lista-ankiet.component.html',
  styleUrls: ['./lista-ankiet.component.css']
})
export class ListaAnkietComponent implements OnInit {

  surveys: Array<Survey>;

  constructor() { }

  ngOnInit(): void {

  }

}
