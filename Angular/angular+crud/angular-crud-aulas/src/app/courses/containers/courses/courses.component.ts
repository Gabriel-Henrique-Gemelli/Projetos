import { CoursesService } from '../../services/courses.service';
import { Component } from '@angular/core';
import { Course } from '../../model/course';
import { Observable, catchError, of } from 'rxjs';
import { MatDialog } from '@angular/material/dialog';
import { ErrorDialogComponent } from 'src/app/shared/shared/components/error-dialog/error-dialog.component';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.scss']
})
export class CoursesComponent {
  courses$:Observable<Course[]>;

  constructor(
    private CoursesService: CoursesService,
    public dialog: MatDialog,
    private router: Router,
    private route: ActivatedRoute
    ) {
    this.courses$ = this.CoursesService.list()
    .pipe(
      catchError(error =>{
        this.onError(`Erro ao carregar cursos`)
        return of ([])
      })
    )
    // this.courses = []
  }


  onError(errorMSG: string) {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMSG
    });
  }
  onAdd(){
    this.router.navigate(['new'],{relativeTo:this.route});
  }

  onEdit(course: Course){
    this.router.navigate(['edit',course._id], {relativeTo:this.route});

  }


}
