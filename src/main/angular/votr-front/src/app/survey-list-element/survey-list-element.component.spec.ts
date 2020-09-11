import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SurveyListElementComponent } from './survey-list-element.component';

describe('SurveyListElementComponent', () => {
  let component: SurveyListElementComponent;
  let fixture: ComponentFixture<SurveyListElementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SurveyListElementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SurveyListElementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
