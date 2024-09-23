import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoisasQueGostaComponent } from './coisas-que-gosta.component';

describe('CoisasQueGostaComponent', () => {
  let component: CoisasQueGostaComponent;
  let fixture: ComponentFixture<CoisasQueGostaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CoisasQueGostaComponent]
    });
    fixture = TestBed.createComponent(CoisasQueGostaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
