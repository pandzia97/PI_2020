import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HelloComponent} from "./hello/hello.component";
import {SurveyComponent} from "./survey/survey.component";
import {ErrorComponent} from "./error/error.component";
import {SuccessfulComponent} from "./successful/successful.component";
import {AboutComponent} from "./about/about.component";
import {ListaAnkietComponent} from "./lista-ankiet/lista-ankiet.component";
import {VoteComponent} from "./vote/vote.component";
import {AnswerCheckComponent} from "./answer-check/answer-check.component";


const routes: Routes = [
  { path: 'dodanie-ankiety', component: SurveyComponent},
  { path: '', component: HelloComponent},
  { path: 'successful', component: SuccessfulComponent},
  { path: 'about', component: AboutComponent},
  { path: 'ankieta', component: SurveyComponent},
  { path: 'lista-ankiet', component: ListaAnkietComponent},
  { path: 'glosuj/:id', component: VoteComponent},
  { path: 'sprawdz/:hash', component: VoteComponent},
  { path: 'sprawdz', component: AnswerCheckComponent},
  { path: 'hashError', component: ErrorComponent},

  { path: '**', component: ErrorComponent}



  //{ path: '**', component: //errorPage}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
