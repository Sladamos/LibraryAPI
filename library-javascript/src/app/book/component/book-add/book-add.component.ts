import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PublishingHouse } from 'src/app/book/model/book';
import { PublishingHouseService } from 'src/app/publishing-house/service/publishing-house.service';
import { NewBook } from '../../model/book';
import { BookService } from '../../service/book.service';
import { v4 as uuidv4 } from 'uuid';

@Component({
  selector: 'app-book-add',
  templateUrl: './book-add.component.html',
  styleUrls: ['./book-add.component.css'],
})
export class BookAddComponent implements OnInit {
  book: NewBook = new NewBook(uuidv4());
  publishingHouse: PublishingHouse = new PublishingHouse();
  id: String = '';
  genres: String = '';

  constructor(
    private service: BookService,
    private publishingHouseService: PublishingHouseService,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.route.params.subscribe((params) => {
      this.id = params['id'];
    });
  }

  ngOnInit(): void {
    this.publishingHouseService.findPublishingHouse(this.id).subscribe({
      next: (publishingHouse) => {
        this.publishingHouse = publishingHouse;
        this.book.publishingHouse = publishingHouse.id;
      },
      error: () => this.router.navigate(['./publishing-houses']),
    });
  }

  onClickSubmit() {
    this.book.genres = this.genres.split('@');
    this.service.createNew(this.book).subscribe({
      next: () => {
        this.router.navigate([
          `./publishing-houses/${this.id}/books/${this.book.id}/content`,
        ]);
      },
      error: (error) => {
        console.log(error);
        window.alert('Invalid input.');
      },
    });
  }
}
