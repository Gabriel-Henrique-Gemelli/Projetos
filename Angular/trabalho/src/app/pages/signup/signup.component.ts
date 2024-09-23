import { Usuario } from './../login/usuario';
import { Component } from '@angular/core';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent {

  public usuario = new Usuario;
  criarUsuario() {
    function validarEmail(email: string): boolean {
      const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
      return emailRegex.test(email);
    }

    if(validarEmail(this.usuario.email) != true){
      alert('email invalido')
      return;
    }



    if (this.usuario.senha !== this.usuario.confirmarsenha){
      alert('os campos de senha devem ser iguais')
      console.log(this.usuario.nome)
      return;
    }


    if(this.usuario.senha.length < 6){
      alert('senha fraca crie uma melhor ')
      return;

    }

    alert('usuario e senha cadastrados ')


    const strUsuarios = localStorage.getItem('usuarios') ||'[]';
    const usuarios = JSON.parse(strUsuarios);
    usuarios.push(this.usuario);
    localStorage.setItem('usuarios',JSON.stringify(usuarios));


  }


}
