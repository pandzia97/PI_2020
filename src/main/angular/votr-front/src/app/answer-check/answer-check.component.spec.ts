import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AnswerCheckComponent } from './answer-check.component';

describe('AnswerCheckComponent', () => {
  let component: AnswerCheckComponent;
  let fixture: ComponentFixture<AnswerCheckComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AnswerCheckComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AnswerCheckComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
