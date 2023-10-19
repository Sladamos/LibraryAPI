import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PublishingHouseListComponent } from './publishing-house/component/publishing-house-list/publishing-house-list.component';
import { PublishingHouseViewComponent } from './publishing-house/component/publishing-house-view/publishing-house-view.component';

const routes: Routes = [
  { path: 'publishing-houses', component: PublishingHouseListComponent },
  { path: 'publishing-houses/:id', component: PublishingHouseViewComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
