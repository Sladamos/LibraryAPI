import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PublishingHouseAddComponent } from './publishing-house-add.component';

describe('PublishingHouseAddComponent', () => {
  let component: PublishingHouseAddComponent;
  let fixture: ComponentFixture<PublishingHouseAddComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PublishingHouseAddComponent]
    });
    fixture = TestBed.createComponent(PublishingHouseAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
