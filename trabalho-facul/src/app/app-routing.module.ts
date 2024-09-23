import { NgModule } from "@angular/core";
import { Routes,RouterModule } from "@angular/router";

import { LoginComponent } from "./pages/login/login.component";
import { SignupComponent } from "./pages/signup/signup.component";
import { MasterComponent } from "./pages/master/master.component";
import { HomeComponent } from "./pages/home/home.component";
import { ReportsComponent } from "./pages/reports/reports.component";
import { EsqueceuSenhaComponent } from "./pages/esqueceu-senha/esqueceu-senha.component";
import { Pagina2Component } from "./pages/home/pagina2/pagina2.component";
import { AuthGuards } from "./pages/guards/auth-guards";

const routes: Routes = [
  //canActivate:[AuthGuards]}
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'master', component: MasterComponent ,canActivate:[AuthGuards]},
  { path: 'home', component: HomeComponent, canActivate:[AuthGuards]},
  { path: 'reports', component: ReportsComponent, canActivate:[AuthGuards]},
  { path: 'esqueceu-senha', component: EsqueceuSenhaComponent},
  { path: 'home/pagina2', component:Pagina2Component, canActivate:[AuthGuards] },
  { path:'', pathMatch: 'full', redirectTo: 'login' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
