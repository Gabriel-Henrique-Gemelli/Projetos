import { Usuario } from './usuario';
import { AuthService } from './auth.service';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {


    public formulario!: FormGroup;


  ngOnInit() {
    this.formulario = new FormGroup({
      email: new FormControl(null, Validators.required),
      senha: new FormControl(null, (Validators.required, Validators.email)),
    });
  }



  public usuario = new Usuario;

  constructor(
    private AuthService: AuthService,
    ) {}

  fazerLogin(){
    this.AuthService.fazerLogin(this.usuario);
    this.formulario.reset()
  }
    }

