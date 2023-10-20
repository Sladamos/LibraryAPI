import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PublishingHouseAddComponent } from './publishing-house/component/publishing-house-add/publishing-house-add.component';
import { PublishingHouseListComponent } from './publishing-house/component/publishing-house-list/publishing-house-list.component';
import { PublishingHouseUpdateComponent } from './publishing-house/component/publishing-house-update/publishing-house-update.component';
import { PublishingHouseViewComponent } from './publishing-house/component/publishing-house-view/publishing-house-view.component';

const routes: Routes = [
  { path: 'publishing-houses', component: PublishingHouseListComponent },
  {
    path: 'publishing-houses/:id/content',
    component: PublishingHouseViewComponent,
  },
  {
    path: 'publishing-houses/create',
    component: PublishingHouseAddComponent,
  },
  {
    path: 'publishing-houses/:id/update',
    component: PublishingHouseUpdateComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
