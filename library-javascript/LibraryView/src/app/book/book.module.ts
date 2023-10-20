import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BookAddComponent } from './component/book-add/book-add.component';
import { BookViewComponent } from './component/book-view/book-view.component';
import { BookUpdateComponent } from './component/book-update/book-update.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [BookAddComponent, BookViewComponent, BookUpdateComponent],
  imports: [CommonModule, FormsModule],
})
export class BookModule {}
