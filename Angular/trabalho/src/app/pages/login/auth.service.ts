import { Router } from '@angular/router';
import { Usuario } from './usuario';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class AuthService {

  public usuarioAutenticado = false;
  public usuarioLogado = new Usuario

  constructor(private router: Router) { }

  fazerLogin(usuario: Usuario) {
    const strUsuarios = localStorage.getItem('usuarios') || '[]';
    const usuarios = JSON.parse(strUsuarios);

    this.usuarioAutenticado = usuarios.some((user: any) =>
      (user.email === usuario.email) && (user.senha === usuario.senha)
    );

    if (this.usuarioAutenticado) {
      this.usuarioLogado = usuario;
      alert('voce foi autorizado');
      this.router.navigate(['/home']);
    } else {
      alert('voce nao foi autorizado');
    }
  }
  usuarioEstaAutenticado() {
    return this.usuarioAutenticado
  }

}
