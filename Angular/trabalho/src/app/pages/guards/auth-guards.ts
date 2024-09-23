import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Router, RouterState, RouterStateSnapshot, UrlTree } from '@angular/router';
import { AuthService } from '../login/auth.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthGuards  {

  constructor(
    private authService: AuthService,
    private router:Router
  ) { }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot  
  ) :Observable <boolean> | boolean{
    if(this.authService.usuarioEstaAutenticado()){
      return true
    }
    this.router.navigate(['/login']);
    return false;
   
  }
}
