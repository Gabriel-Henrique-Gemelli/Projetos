import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AboutHerComponent } from './about-her.component';

describe('AboutHerComponent', () => {
  let component: AboutHerComponent;
  let fixture: ComponentFixture<AboutHerComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AboutHerComponent]
    });
    fixture = TestBed.createComponent(AboutHerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
