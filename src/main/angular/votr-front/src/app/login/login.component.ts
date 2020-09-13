import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  payload: LoginPayload;

  public hideFlag = false;

  constructor(private http: HttpClient) {
  }

  ngOnInit(): void {
    this.hideFlag = true;
    this.payload = new LoginPayload();
  }

  verifyLoginData(): void {
    //   if (this.hideFlag == true) { //jesli zwrocony blad logowania
    //     this.hideFlag = false; //wyswietl komunikat o bledzie
    //   } else {
    //     this.hideFlag = true; //przejdz dalej i zapisz token sesji do ciasteczka
    //   }


  }

  login(login, password) {
    this.payload.login = login;
    this.payload.password = password;

    console.log(JSON.stringify(this.payload));

    this.http.post<any>("http://votr-test.piwowarczyk.ovh/api/v1/auth/login", JSON.stringify(this.payload), {
        headers: new HttpHeaders({'Content-Type': 'application/json'})
      }
    ).subscribe(data => {

    });

  }

}
class LoginPayload {
  public login: String;
  public password: String;

  constructor() {
    this.login = "";
    this.password = "";
  }
}
