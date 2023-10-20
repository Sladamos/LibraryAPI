import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { catchError, throwError } from 'rxjs';
import { Book } from 'src/app/book/model/books';
import { BookService } from 'src/app/book/service/book.service';
import { PublishingHouse } from '../../model/publishing-house';
import { PublishingHouseService } from '../../service/publishing-house.service';

@Component({
  selector: 'app-publishing-house-view',
  templateUrl: './publishing-house-view.component.html',
  styleUrls: ['./publishing-house-view.component.css'],
})
export class PublishingHouseViewComponent implements OnInit {
  publishingHouse: PublishingHouse = new PublishingHouse();
  books: Book[] = [];
  id: String = '';

  constructor(
    private booksService: BookService,
    private service: PublishingHouseService,
    private route: ActivatedRoute,
    private router: Router
  ) {
    this.route.params.subscribe((params) => (this.id = params['id']));
  }

  ngOnInit(): void {
    this.service.findPublishingHouse(this.id).subscribe({
      next: (publishingHouse) => {
        this.publishingHouse = publishingHouse;
        this.booksService
          .findAllBooksByPublishingHouseName(publishingHouse.name)
          .subscribe((books) => {
            this.books = books.books;
          });
      },
      error: () => {
        this.router.navigate(['./publishing-houses']);
      },
    });
  }

  onDelete(id: String): void {
    this.booksService.deleteBook(id).subscribe((el) => {
      this.books = this.books.filter((el) => el.id != id);
    });
  }
}
