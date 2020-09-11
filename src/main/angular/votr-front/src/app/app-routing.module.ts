import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import {HelloComponent} from "./hello/hello.component";
import {RejestracjaComponent} from "./rejestracja/rejestracja.component";
import {SurveyComponent} from "./survey/survey.component";
import {ErrorComponent} from "./error/error.component";
import {SuccessfulComponent} from "./successful/successful.component";
import {AboutComponent} from "./about/about.component";

const routes: Routes = [
  { path: 'login-component', component: LoginComponent },
  { path: 'dodanie-ankiety', component: SurveyComponent},
  { path: '', component: HelloComponent},
  { path: 'register-component', component: RejestracjaComponent},
  { path: 'successful', component: SuccessfulComponent},
  { path: 'about', component: AboutComponent},
  { path: 'ankieta', component: SurveyComponent},
  { path: '**', component: ErrorComponent}



  //{ path: '**', component: //errorPage}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
