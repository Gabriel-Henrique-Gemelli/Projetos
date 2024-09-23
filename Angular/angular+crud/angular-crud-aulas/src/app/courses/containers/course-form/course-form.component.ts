import { Component } from '@angular/core';
import { FormBuilder, NonNullableFormBuilder, Validators } from '@angular/forms';
import { CoursesService } from '../../services/courses.service';
import { Location } from '@angular/common';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-course-form',
  templateUrl: './course-form.component.html',
  styleUrls: ['./course-form.component.scss']
})
export class CourseFormComponent {

  form = this.formBuilder.group({
    name:[''],
    category: ['']
  });

  constructor(private formBuilder: NonNullableFormBuilder,
    private service:CoursesService,
    private snackBar: MatSnackBar,
    private location:Location) {
   }

   onSubmit(){
      this.service.save(this.form.value)
      .subscribe(result => this.onSucess(),error => this.onError());
      this.onCancel();
   }
   onCancel(){
    this.location.back();
   }

   private onError() {
    this.snackBar.open('Erro ao carregar curso.', 'Ok', {duration:2000 });

   }
   private onSucess() {
    this.snackBar.open('Curso salvo com sucesso!.', 'Ok', {duration:2000 });

   }

}
