import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HerAdvicesComponent } from './her-advices.component';

describe('HerAdvicesComponent', () => {
  let component: HerAdvicesComponent;
  let fixture: ComponentFixture<HerAdvicesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HerAdvicesComponent]
    });
    fixture = TestBed.createComponent(HerAdvicesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
