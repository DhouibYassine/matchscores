import {APP_INITIALIZER, NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {LoginComponent} from './login/login.component';
import {SecuredComponent} from './secured/secured.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {KachelComponent} from "./common/kachel/kachel.component";
import {KeycloakAngularModule, KeycloakService} from "keycloak-angular";
import {HttpClientModule} from "@angular/common/http";
import {MatButtonModule} from "@angular/material/button";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatMenuModule} from "@angular/material/menu";
import {MatIconModule} from "@angular/material/icon";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatTableModule} from "@angular/material/table";
import {MatchDayComponent} from './match-day/match-day.component';
import {CommonModule, DatePipe} from "@angular/common";
import { MatchCardsComponent } from './match-cards/match-cards.component';
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatCardModule} from "@angular/material/card";
import { TeamComponent } from './team/team.component';


function initializeKeycloak(keycloak: KeycloakService) {
  return () =>
    keycloak.init({
      config: {
        url: 'http://localhost:8080',
        realm: 'flash-score',
        clientId: 'frontend'
      },
      initOptions: {
        onLoad: 'check-sso'
      }
    });
}

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SecuredComponent,
    MatchDayComponent,
    MatchCardsComponent,
    TeamComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    KachelComponent,
    KeycloakAngularModule,
    HttpClientModule,
    MatButtonModule,
    MatToolbarModule,
    MatMenuModule,
    MatIconModule,
    MatFormFieldModule,
    MatTableModule,
    CommonModule,
    MatSidenavModule,
    MatCardModule
  ],
  providers: [
    DatePipe,
    {
      provide: APP_INITIALIZER,
      useFactory: initializeKeycloak,
      multi: true,
      deps: [KeycloakService]
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
