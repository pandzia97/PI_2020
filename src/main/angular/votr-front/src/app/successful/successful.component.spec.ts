import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SuccessfulComponent } from './successful.component';

describe('SuccessfulComponent', () => {
  let component: SuccessfulComponent;
  let fixture: ComponentFixture<SuccessfulComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SuccessfulComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SuccessfulComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
