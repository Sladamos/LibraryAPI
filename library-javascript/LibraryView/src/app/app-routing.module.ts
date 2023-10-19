import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PublishingHouseListComponent } from './publishing-house/publishing-house-list/publishing-house-list.component';

const routes: Routes = [
  { path: 'publishing-houses', component: PublishingHouseListComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
