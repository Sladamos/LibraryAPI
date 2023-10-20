import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PublishingHouseService } from 'src/app/publishing-house/service/publishing-house.service';
import { Book } from '../../model/book';
import { BookService } from '../../service/book.service';

@Component({
  selector: 'app-book-view',
  templateUrl: './book-view.component.html',
  styleUrls: ['./book-view.component.css'],
})
export class BookViewComponent implements OnInit {
  book: Book = new Book();
  id: String = '';
  publishingHouseId: String = '';

  constructor(
    private service: BookService,
    private publishingHouseService: PublishingHouseService,
    private route: ActivatedRoute,
    private router: Router
  ) {
    this.route.params.subscribe((params) => {
      this.publishingHouseId = params['id'];
      this.id = params['bookId'];
    });
  }

  ngOnInit(): void {
    this.publishingHouseService
      .findPublishingHouse(this.publishingHouseId)
      .subscribe((house) => {
        this.service.findBook(this.id).subscribe((book) => {
          this.book = book;
        });
      });
  }

  returnToPublishingHouseContent(): void {
    this.publishingHouseService
      .findPublishingHouse(this.publishingHouseId)
      .subscribe((house) => {
        this.router.navigate([`./publishing-houses/${house.id}/content`]);
      });
  }
}
