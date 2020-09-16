import { Component, OnInit } from '@angular/core';
import {Survey} from "../survey/survey";
import {SurveyListElementComponent} from "../survey-list-element/survey-list-element.component";
import {HttpClient} from "@angular/common/http";
import {computeStartOfLinePositions} from "@angular/compiler-cli/ngcc/src/sourcemaps/source_file";


@Component({
  selector: 'app-lista-ankiet',
  templateUrl: './lista-ankiet.component.html',
  styleUrls: ['./lista-ankiet.component.css']
})
export class ListaAnkietComponent implements OnInit {

  surveys: Array<Survey>;


  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.http.get("http://votr-test.piwowarczyk.ovh/api/v1/surveys").subscribe(data=>{
      this.surveys = data as Array<Survey>;
    })
  }
}
