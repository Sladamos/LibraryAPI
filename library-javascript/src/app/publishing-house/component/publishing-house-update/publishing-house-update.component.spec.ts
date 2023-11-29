import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PublishingHouseUpdateComponent } from './publishing-house-update.component';

describe('PublishingHouseUpdateComponent', () => {
  let component: PublishingHouseUpdateComponent;
  let fixture: ComponentFixture<PublishingHouseUpdateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PublishingHouseUpdateComponent]
    });
    fixture = TestBed.createComponent(PublishingHouseUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
