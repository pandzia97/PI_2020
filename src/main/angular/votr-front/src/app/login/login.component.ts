import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public hideFlag = false;

  constructor() {
  }

  ngOnInit(): void {
    this.hideFlag = true;
  }

  verifyLoginData(): void{
    if (this.hideFlag == true) { //jesli zwrocony blad logowania
      this.hideFlag = false; //wyswietl komunikat o bledzie
    } else {
      this.hideFlag = true; //przejdz dalej i zapisz token sesji do ciasteczka
    }
  }

}
