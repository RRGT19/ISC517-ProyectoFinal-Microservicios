import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalRequestServiceComponent } from './modal-request-service.component';

describe('ModalRequestServiceComponent', () => {
  let component: ModalRequestServiceComponent;
  let fixture: ComponentFixture<ModalRequestServiceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModalRequestServiceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModalRequestServiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
