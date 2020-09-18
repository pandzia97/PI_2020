import {Component, OnInit} from '@angular/core';
import {Survey} from "../survey/survey";
import {HttpClient} from "@angular/common/http";
import {GlobalVariables} from "../common/global-variables";


@Component({
  selector: 'app-lista-ankiet',
  templateUrl: './lista-ankiet.component.html',
  styleUrls: ['./lista-ankiet.component.css']
})
export class ListaAnkietComponent implements OnInit {

  surveys: Array<Survey>;

  constructor(private http: HttpClient) {
  }

  ngOnInit(): void {
    this.http.get(`${GlobalVariables.apiUrl}/surveys`).subscribe(data => {
      this.surveys = data as Array<Survey>;
    })
  }
}
