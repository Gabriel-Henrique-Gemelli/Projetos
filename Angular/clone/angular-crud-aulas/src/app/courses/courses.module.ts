import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CoursesRoutingModule } from './courses-routing.module';
import { CoursesComponent } from './containers/courses/courses.component';
import { AngularMaterializeModule } from '../shared/angular-materialize/angular-materialize.module';
import { SharedModule } from '../shared/shared/shared.module';
import { CourseFormComponent } from './containers/course-form/course-form.component';
import { ReactiveFormsModule } from '@angular/forms';
import { CoursesListComponent } from './components/courses-list/courses-list.component';


@NgModule({
  declarations: [
    CoursesComponent,
    CourseFormComponent,
    CoursesListComponent
  ],
  imports: [
    CommonModule,
    CoursesRoutingModule,
    AngularMaterializeModule,
    SharedModule,
    ReactiveFormsModule,
  ]
})
export class CoursesModule { }
