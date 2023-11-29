export class PublishingHouse {
  name: String;
  id: String;

  constructor(id?: String, name?: String) {
    this.id = id || '';
    this.name = name || '';
  }
}

export class Book {
  id: String;
  title: String;
  isbn: String;
  author: String;
  numberOfPages: number;
  genres: String[];
  publishingHouse: PublishingHouse;

  constructor(
    id?: string,
    title?: string,
    isbn?: string,
    author?: string,
    numberOfPages?: number,
    genres?: string[],
    publishingHouse?: PublishingHouse
  ) {
    this.id = id || '';
    this.title = title || '';
    this.isbn = isbn || '';
    this.author = author || '';
    this.numberOfPages = numberOfPages || 0;
    this.genres = genres || [];
    this.publishingHouse = publishingHouse || new PublishingHouse();
  }
}

export class NewBook {
  id: String;
  title: String;
  isbn: String;
  author: String;
  numberOfPages: number;
  genres: String[];
  publishingHouse: String;

  constructor(
    id?: string,
    title?: string,
    isbn?: string,
    author?: string,
    numberOfPages?: number,
    genres?: string[],
    publishingHouse?: String
  ) {
    this.id = id || '';
    this.title = title || '';
    this.isbn = isbn || '';
    this.author = author || '';
    this.numberOfPages = numberOfPages || 0;
    this.genres = genres || [];
    this.publishingHouse = publishingHouse || '';
  }
}
