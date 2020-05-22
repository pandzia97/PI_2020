import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaAnkietComponent } from './lista-ankiet.component';

describe('ListaAnkietComponent', () => {
  let component: ListaAnkietComponent;
  let fixture: ComponentFixture<ListaAnkietComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListaAnkietComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaAnkietComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
