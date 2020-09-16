import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListaAnkietComponent } from './lista-ankiet/lista-ankiet.component';
import { RejestracjaComponent } from './rejestracja/rejestracja.component';
import { SurveyComponent } from './survey/survey.component';
import { MenuComponent } from './menu/menu.component';
import { HelloComponent } from './hello/hello.component';
import { StopkaComponent } from './stopka/stopka.component';
import { ErrorComponent } from './error/error.component';
import { SuccessfulComponent } from './successful/successful.component';
import { QuestionComponent } from './question/question.component';
import { OptionComponent } from './option/option.component';
import {FormsModule} from "@angular/forms";
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { AboutComponent } from './about/about.component';
import { MainComponent } from './main/main.component';
import { SurveyListElementComponent } from './survey-list-element/survey-list-element.component';
import {HttpClientModule} from "@angular/common/http";
import { VoteComponent } from './vote/vote.component';
import { AnswerComponent } from './answer/answer.component';
import { AnswerCheckComponent } from './answer-check/answer-check.component';
import { HashDisplayComponent } from './hash-display/hash-display.component';




@NgModule({
  declarations: [
    AppComponent,
    ListaAnkietComponent,
    RejestracjaComponent,
    SurveyComponent,
    MenuComponent,
    HelloComponent,
    StopkaComponent,
    ErrorComponent,
    SuccessfulComponent,
    QuestionComponent,
    OptionComponent,
    AboutComponent,
    MainComponent,

    SurveyListElementComponent,
    VoteComponent,
    AnswerComponent,
    AnswerCheckComponent,
    HashDisplayComponent




  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    FontAwesomeModule,
    HttpClientModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
