import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SeuAmorComponent } from './seu-amor.component';

describe('SeuAmorComponent', () => {
  let component: SeuAmorComponent;
  let fixture: ComponentFixture<SeuAmorComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SeuAmorComponent]
    });
    fixture = TestBed.createComponent(SeuAmorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
