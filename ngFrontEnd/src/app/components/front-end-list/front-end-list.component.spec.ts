import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FrontEndListComponent } from './front-end-list.component';

describe('FrontEndListComponent', () => {
  let component: FrontEndListComponent;
  let fixture: ComponentFixture<FrontEndListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FrontEndListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FrontEndListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
