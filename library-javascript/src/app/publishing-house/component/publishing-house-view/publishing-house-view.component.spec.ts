import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PublishingHouseViewComponent } from './publishing-house-view.component';

describe('PublishingHouseViewComponent', () => {
  let component: PublishingHouseViewComponent;
  let fixture: ComponentFixture<PublishingHouseViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PublishingHouseViewComponent]
    });
    fixture = TestBed.createComponent(PublishingHouseViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
