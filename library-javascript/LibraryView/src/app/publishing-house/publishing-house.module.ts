import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PublishingHouseListComponent } from './component/publishing-house-list/publishing-house-list.component';
import { PublishingHouseViewComponent } from './component/publishing-house-view/publishing-house-view.component';
import { PublishingHouseAddComponent } from './component/publishing-house-add/publishing-house-add.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    PublishingHouseListComponent,
    PublishingHouseViewComponent,
    PublishingHouseAddComponent,
  ],
  imports: [CommonModule, FormsModule],
})
export class PublishingHouseModule {}
