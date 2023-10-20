import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Book } from '../model/book';
import { Books } from '../model/books';

@Injectable({
  providedIn: 'root',
})
export class BookService {
  constructor(private http: HttpClient) {}

  findBook(id: String) {
    return this.http.get<Book>(`http://172.17.0.1:8084/api/books/${id}`);
  }

  findAllBooksByPublishingHouseName(publishingHouseName: String) {
    return this.http.get<Books>(
      `http://172.17.0.1:8084/api/books?publishing-house=${publishingHouseName}`
    );
  }

  deleteBook(id: String) {
    return this.http.delete<void>(`http://172.17.0.1:8084/api/books/${id}`);
  }

  findAllBooks(publishingHouseName: String) {
    return this.http.get<Books>(
      `http://172.17.0.1:8084/api/books/${publishingHouseName}`
    );
  }
}
