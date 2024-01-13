import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AuthGuard} from "./authentication/auth.guard";
import {SecuredComponent} from "./secured/secured.component";
import {MatchDayComponent} from "./match-day/match-day.component";
import {MatchCardsComponent} from "./match-cards/match-cards.component";
import {TeamComponent} from "./team/team.component";
import {LoginComponent} from "./login/login.component";

const routes: Routes = [
  {
    path: "",
    component: LoginComponent,
  },
  {
    path: "team",
    canActivate: [AuthGuard],
    component: TeamComponent,
    data: {roles: ['USER']}
  },
  {
    path: "matchDay",
    canActivate: [AuthGuard],
    component: MatchDayComponent,
    data: {roles: ['USER']}
  },
  {
    path: "matches",
    canActivate: [AuthGuard],
    component: MatchCardsComponent,
    data: {roles: ['USER']}
  },
  {
    path: "secured",
    canActivate: [AuthGuard],
    component: SecuredComponent,
    data: {roles: ['ADMIN']}
  },
  {
    path: '**', redirectTo: "matchDay"
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
