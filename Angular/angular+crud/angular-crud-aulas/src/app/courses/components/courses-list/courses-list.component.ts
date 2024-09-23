import { Course } from './../../model/course';
import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-courses-list',
  templateUrl: './courses-list.component.html',
  styleUrls: ['./courses-list.component.scss']
})
export class CoursesListComponent {
  @Input() courses: Course[] = [];
  @Output() add = new EventEmitter(false);
  @Output() edit = new EventEmitter(false);

  readonly displayedColumns = ['name','category','actions'];



  onAdd(){
    this.add.emit(true)
  }

  onEdit(Course: Course) {
    this.edit.emit(Course);
  }
}
