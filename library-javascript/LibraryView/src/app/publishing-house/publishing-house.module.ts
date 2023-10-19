import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PublishingHouseListComponent } from './component/publishing-house-list/publishing-house-list.component';
import { PublishingHouseViewComponent } from './component/publishing-house-view/publishing-house-view.component';

@NgModule({
  declarations: [PublishingHouseListComponent, PublishingHouseViewComponent],
  imports: [CommonModule],
})
export class PublishingHouseModule {}
