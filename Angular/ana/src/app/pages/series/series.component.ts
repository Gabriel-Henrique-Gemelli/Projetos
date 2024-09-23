import { Component } from '@angular/core';
import {MatDialog} from '@angular/material/dialog';


@Component({
  selector: 'app-series',
  templateUrl: './series.component.html',
  styleUrls: ['./series.component.scss']
})
export class SeriesComponent {

  constructor(public dialog: MatDialog) {}

  openDialog() {
    // const dialogRef = this.dialog.open(picture);

    // dialogRef.afterClosed().subscribe(result => {
    //   console.log(`Dialog result: ${result}`);
    // });
  }
}
// @Component({
//   selector: 'picture',
//   templateUrl: 'src/app/pages/series/picture.html',
//   standalone: true,
// })
export class DialogContentExampleDialog {}
