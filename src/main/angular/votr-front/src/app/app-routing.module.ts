import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import {HelloComponent} from "./hello/hello.component";
import {RejestracjaComponent} from "./rejestracja/rejestracja.component";

const routes: Routes = [
  { path: 'login-component', component: LoginComponent },
  { path: '', component: HelloComponent},
  { path: 'register-component', component: RejestracjaComponent}

  //{ path: '**', component: //errorPage}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
