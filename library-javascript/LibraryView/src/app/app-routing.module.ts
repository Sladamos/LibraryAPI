import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookViewComponent } from './book/component/book-view/book-view.component';
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
  {
    path: 'publishing-houses/:id/books/:bookId/content',
    component: BookViewComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
