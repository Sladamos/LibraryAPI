import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Book, NewBook } from '../model/book';
import { Books } from '../model/books';

@Injectable({
  providedIn: 'root',
})
export class BookService {
  constructor(private http: HttpClient) {}

  findBook(id: String) {
    return this.http.get<Book>(`/api/books/${id}`);
  }

  update(book: Book) {
    return this.http.patch<void>(
      `/api/books/${book.id}`,
      book
    );
  }

  createNew(book: NewBook) {
    return this.http.put<void>(
      `/api/books/${book.id}`,
      book
    );
  }
  findAllBooksByPublishingHouseName(publishingHouseName: String) {
    return this.http.get<Books>(
      `/api/books?publishing-house=${publishingHouseName}`
    );
  }

  deleteBook(id: String) {
    return this.http.delete<void>(`/api/books/${id}`);
  }

  findAllBooks(publishingHouseName: String) {
    return this.http.get<Books>(
      `/api/books/${publishingHouseName}`
    );
  }
}
