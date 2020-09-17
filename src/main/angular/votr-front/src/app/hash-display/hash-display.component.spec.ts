import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HashDisplayComponent } from './hash-display.component';

describe('HashDisplayComponent', () => {
  let component: HashDisplayComponent;
  let fixture: ComponentFixture<HashDisplayComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HashDisplayComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HashDisplayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
