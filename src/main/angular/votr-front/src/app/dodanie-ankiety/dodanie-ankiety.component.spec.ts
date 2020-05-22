import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DodanieAnkietyComponent } from './dodanie-ankiety.component';

describe('DodanieAnkietyComponent', () => {
  let component: DodanieAnkietyComponent;
  let fixture: ComponentFixture<DodanieAnkietyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DodanieAnkietyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DodanieAnkietyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
