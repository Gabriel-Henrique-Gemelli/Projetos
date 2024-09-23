import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './pages/login/login.component';
import { HomeComponent } from './pages/home/home.component';
import { SignupComponent } from './pages/signup/signup.component';
import { ReportsComponent } from './pages/reports/reports.component';
import { MasterComponent } from './pages/master/master.component';
import { EsqueceuSenhaComponent } from './pages/esqueceu-senha/esqueceu-senha.component';
import { AuthGuards } from './pages/guards/auth-guards';
import { AuthService } from './pages/login/auth.service';
import { Pagina2Component } from './pages/home/pagina2/pagina2.component';
import { HttpClient } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    SignupComponent,
    ReportsComponent,
    MasterComponent,
    EsqueceuSenhaComponent,
    Pagina2Component,




  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,



  ],
  providers: [AuthGuards,AuthService,HttpClient],
  bootstrap: [AppComponent]
})
export class AppModule { }
