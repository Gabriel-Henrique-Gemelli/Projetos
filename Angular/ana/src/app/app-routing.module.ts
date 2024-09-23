import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { AboutHerComponent } from './pages/about-her/about-her.component';
import { MusicasComponent } from './pages/musicas/musicas.component';
import { HerAdvicesComponent } from './pages/her-advices/her-advices.component';
import { FotosComponent } from './pages/fotos/fotos.component';
import { CoisasQueGostaComponent } from './pages/coisas-que-gosta/coisas-que-gosta.component';
import { SeuAmorComponent } from './pages/seu-amor/seu-amor.component';
import { SeriesComponent } from './pages/series/series.component';

const routes: Routes = [
  {path:'aboutHer',
component:AboutHerComponent,
children: [
  {path:'musicas',component: MusicasComponent},
  {path:'herAdvices',component:HerAdvicesComponent},
  {path:'fotos',component:FotosComponent},
  {path:'coisasQueGosta',component:CoisasQueGostaComponent},
  {path:'seuAmor',component:SeuAmorComponent},
  {path:'series e filmes',component:SeriesComponent}
]},
  {path:'', redirectTo:'home', pathMatch:'full'},
  {path: 'home', component:HomeComponent},
  {path:'aboutHer', component:AboutHerComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
