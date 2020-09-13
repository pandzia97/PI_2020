import {Component, Input, OnInit} from '@angular/core';
import {Survey} from "../survey/survey";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {stringify} from "querystring";
import {log} from "util";

@Component({
  selector: 'app-rejestracja',
  templateUrl: './rejestracja.component.html',
  styleUrls: ['./rejestracja.component.css']
})
export class RejestracjaComponent implements OnInit {


  payload: RegisterPayload;

  constructor(private http: HttpClient) {

  }

  ngOnInit(): void {

    this.payload =  new RegisterPayload();

  }

  verifyRegisterData() {

  }

  register(login, password, email){
    this.payload.login = login;
    this.payload.password = password;
    this.payload.email = email;

    //TODO implementacja requestu do API

    console.log(JSON.stringify(this.payload));
    console.log(this.payload.email);

    this.http.post<any>("http://votr-test.piwowarczyk.ovh/api/v1/auth/register",JSON.stringify(this.payload),{
      headers : new HttpHeaders({ 'Content-Type': 'application/json' })}
    ).subscribe(data => {

    });
  }
}

class RegisterPayload {
    public login: String;
    public password: String;
    public email: String;


  constructor() {
  this.login = "";
  this.password = "";
  this.email = "";
  }
}
