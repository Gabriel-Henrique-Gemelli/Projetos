import { CoursesService } from '../../services/courses.service';
import { Component } from '@angular/core';
import { Course } from '../../model/course';
import { Observable, catchError, of } from 'rxjs';
import { MatDialog } from '@angular/material/dialog';
import { ErrorDialogComponent } from 'src/app/shared/shared/components/error-dialog/error-dialog.component';
import { ActivatedRoute, Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ConfirmationDialogComponent } from 'src/app/shared/shared/components/confirmation-dialog/confirmation-dialog.component';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.scss']
})
export class CoursesComponent {
  courses$:Observable<Course[]> | null = null;

  constructor(
    private CoursesService: CoursesService,
    public dialog: MatDialog,
    private router: Router,
    private route: ActivatedRoute,
    private snackBar: MatSnackBar,
    ) {
    this.refresh();
  }


  refresh(){
    this.courses$ = this.CoursesService.list()
    .pipe(
      catchError(error =>{
        this.onError(`Erro ao carregar cursos`)
        return of ([])
      })
    )
  }


  onError(errorMSG: string) {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMSG
    });
  }
  onAdd(){
    this.router.navigate(['new'], {relativeTo:this.route});
  }

  onEdit(course: Course){
    this.router.navigate(['edit', course._id], {relativeTo:this.route});

  }

  onRemove(course: Course) {

    {
      const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
        data: "deseja realmente remover esse curso? ",
      });

      dialogRef.afterClosed().subscribe((result: boolean) => {
        if (result == true) {
          this.CoursesService.remove(course._id)
          .subscribe(
            () => {
              console.log('sim')
              this.refresh();
              this.snackBar.open('Curso removido com sucesso!.', 'x', {
                duration: 2000,
                verticalPosition: 'top',
                horizontalPosition: 'center',
              });
            },
            erro => this.onError ('erro ao deletar curso')
          );
        }
      });
    }





  }


}
