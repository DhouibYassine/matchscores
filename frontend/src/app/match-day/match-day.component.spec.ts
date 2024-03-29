import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MatchDayComponent } from './match-day.component';

describe('MatchDayComponent', () => {
  let component: MatchDayComponent;
  let fixture: ComponentFixture<MatchDayComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MatchDayComponent]
    });
    fixture = TestBed.createComponent(MatchDayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
