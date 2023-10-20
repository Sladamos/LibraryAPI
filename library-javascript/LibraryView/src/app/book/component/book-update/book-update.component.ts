import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PublishingHouseService } from 'src/app/publishing-house/service/publishing-house.service';
import { Book } from '../../model/book';
import { BookService } from '../../service/book.service';

@Component({
  selector: 'app-book-update',
  templateUrl: './book-update.component.html',
  styleUrls: ['./book-update.component.css'],
})
export class BookUpdateComponent implements OnInit {
  id: String = '';
  book: Book = new Book();

  constructor(
    private service: BookService,
    private publishingHouseService: PublishingHouseService,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.route.params.subscribe((params) => {
      this.book.id = params['bookId'];
      this.id = params['id'];
    });
  }

  ngOnInit(): void {
    this.publishingHouseService.findPublishingHouse(this.id).subscribe({
      next: () => {
        this.service.findBook(this.book.id).subscribe({
          next: (book) => {
            this.book = book;
          },
          error: () => {
            this.router.navigate([`./publishing-houses/${this.id}/content`]);
          },
        });
      },
      error: () => {
        this.router.navigate(['./publishing-houses']);
      },
    });
  }

  onClickSubmit() {
    this.service.update(this.book).subscribe({
      next: () => {
        this.router.navigate([
          `./publishing-houses/${this.id}/books/${this.book.id}/content`,
        ]);
      },
      error: () => window.alert('Invalid input.'),
    });
  }
}
