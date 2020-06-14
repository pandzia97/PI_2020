import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DodanieAnkietySuccessfulComponent } from './dodanie-ankiety-successful.component';

describe('DodanieAnkietySuccessfulComponent', () => {
  let component: DodanieAnkietySuccessfulComponent;
  let fixture: ComponentFixture<DodanieAnkietySuccessfulComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DodanieAnkietySuccessfulComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DodanieAnkietySuccessfulComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
