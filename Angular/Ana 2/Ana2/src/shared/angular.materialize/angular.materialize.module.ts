import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatTabsModule } from '@angular/material/tabs';



@NgModule({
  imports:[
    MatTabsModule
  ],
  exports: [
    CommonModule,
    MatTabsModule
  ]
})
export class AngularMaterializeModule { }
