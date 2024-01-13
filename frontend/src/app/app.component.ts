import {Component} from '@angular/core';
import {AuthService} from "./authentication/auth.service";
import {KeycloakService} from "keycloak-angular";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'frontend';

  constructor(public keycloakService: KeycloakService,
              public authService: AuthService,) {
  }

  login() {
    this.authService.login()
  }

  logout() {
    this.authService.logout()
  }

  get username(): string {
    return this.authService.getUsername();
  }
}
