import { Component } from '@angular/core';
import { NonNullableFormBuilder, Validators } from '@angular/forms';
import { CoursesService } from '../../services/courses.service';
import { Location } from '@angular/common';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { Course } from '../../model/course';

@Component({
  selector: 'app-course-form',
  templateUrl: './course-form.component.html',
  styleUrls: ['./course-form.component.scss'],
})
export class CourseFormComponent{
    form = this.formBuilder.group({
    _id:[''],
    name: ['',
    [Validators.required,
    Validators.minLength(1),
    Validators.maxLength(20)]],
    category: ['',
    [ Validators.required]],
  });


  constructor(
    private formBuilder: NonNullableFormBuilder,
    private service: CoursesService,
    private snackBar: MatSnackBar,
    private location: Location,
    private route: ActivatedRoute
  ) {
    const course: Course = this.route.snapshot.data['course'];
    this.form.setValue({
      _id: course._id,
      name: course.name,
      category: course.category,

    });
  }


  onSubmit() {
    this.service.save(this.form.value).subscribe(
      (result) => this.onSucess(),
      (error) => this.onError()
    );
    this.onCancel();
  }
  onCancel() {
    this.location.back();
  }

  private onError() {
    this.snackBar.open('Erro ao carregar curso.', 'Ok', { duration: 2000 });
  }
  private onSucess() {
    this.snackBar.open('Curso salvo com sucesso!.', 'Ok', { duration: 2000 });
  }
}
