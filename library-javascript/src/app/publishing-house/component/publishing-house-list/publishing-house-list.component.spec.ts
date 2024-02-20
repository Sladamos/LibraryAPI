import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PublishingHouseListComponent } from './publishing-house-list.component';

describe('PublishingHouseListComponent', () => {
  let component: PublishingHouseListComponent;
  let fixture: ComponentFixture<PublishingHouseListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PublishingHouseListComponent]
    });
    fixture = TestBed.createComponent(PublishingHouseListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
