import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { ListaAnkietComponent } from './lista-ankiet/lista-ankiet.component';
import { RejestracjaComponent } from './rejestracja/rejestracja.component';
import { DodanieAnkietyComponent } from './dodanie-ankiety/dodanie-ankiety.component';
import { MenuComponent } from './menu/menu.component';
import { TestComponent } from './test/test.component';
import { HelloComponent } from './hello/hello.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ListaAnkietComponent,
    RejestracjaComponent,
    DodanieAnkietyComponent,
    MenuComponent,
    TestComponent,
    HelloComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
