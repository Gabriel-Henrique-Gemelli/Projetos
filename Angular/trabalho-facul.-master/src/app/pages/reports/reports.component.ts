import { Component } from '@angular/core';
import { LoginComponent } from '../login/login.component';
import { FormControlName, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-reports',
  templateUrl: './reports.component.html',
  styleUrls: ['./reports.component.scss']
})

export class ReportsComponent {
  public formulario!: FormGroup;


exibirMensagem() {
alert('reclamaçao enviada com sucesso')

}

}
