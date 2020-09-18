import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-error',
  templateUrl: './error.component.html',
  styleUrls: ['./error.component.css']
})
export class ErrorComponent implements OnInit {

  public message: String;

  constructor(private route:ActivatedRoute) { }

  ngOnInit(): void {
    if(this.route.routeConfig.path.startsWith("hashError")){
      this.message = "WYKRYTO NIEZGODNOŚĆ KLUCZY!!! Podejrzenie ingerencji w bazę danych!";
    }else{
      this.message="";
    }
  }

}
