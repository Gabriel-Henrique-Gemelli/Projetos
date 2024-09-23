import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AngularMaterializeModule } from './shared/angular.materialize.module';
import { AboutHerComponent } from './pages/about-her/about-her.component';
import { HomeComponent } from './pages/home/home.component';
import { MusicasComponent } from './pages/musicas/musicas.component';
import { HttpClientModule } from '@angular/common/http';
import { HerAdvicesComponent } from './pages/her-advices/her-advices.component';
import { FotosComponent } from './pages/fotos/fotos.component';
import { CoisasQueGostaComponent } from './pages/coisas-que-gosta/coisas-que-gosta.component';
import { SeuAmorComponent } from './pages/seu-amor/seu-amor.component';
import { SeriesComponent } from './pages/series/series.component';

@NgModule({
  declarations: [
    AppComponent,
    AboutHerComponent,
    HomeComponent,
    MusicasComponent,
    HerAdvicesComponent,
    FotosComponent,
    CoisasQueGostaComponent,
    SeuAmorComponent,
    SeriesComponent,
    
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    AngularMaterializeModule,
    HttpClientModule,
    
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
