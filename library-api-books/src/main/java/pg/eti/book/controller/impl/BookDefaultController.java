package pg.eti.book.controller.impl;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pg.eti.book.controller.api.BookController;
import pg.eti.book.dto.GetBookResponse;
import pg.eti.book.dto.GetBooksResponse;
import pg.eti.book.dto.PatchBookRequest;
import pg.eti.book.dto.PutBookRequest;
import pg.eti.book.function.BookToResponseFunction;
import pg.eti.book.function.BooksToResponseFunction;
import pg.eti.book.function.RequestToBookFunction;
import pg.eti.book.function.UpdateBookWithRequestFunction;
import pg.eti.book.service.api.BookService;
import pg.eti.book.service.exception.BookServiceException;

import java.util.UUID;

@RestController
@Log
public class BookDefaultController implements BookController {

	private final BookService service;

	private final BookToResponseFunction bookToResponse;

	private final BooksToResponseFunction booksToResponse;

	private final RequestToBookFunction requestToBook;

	private final UpdateBookWithRequestFunction updateBookWithRequest;

	@Autowired
	public BookDefaultController(
			BookService service,
			BookToResponseFunction bookToResponse,
			BooksToResponseFunction booksToResponse,
			RequestToBookFunction requestToBook,
			UpdateBookWithRequestFunction updateBookWithRequest) {
		this.service = service;
		this.bookToResponse = bookToResponse;
		this.booksToResponse = booksToResponse;
		this.requestToBook = requestToBook;
		this.updateBookWithRequest = updateBookWithRequest;
	}

	@Override
	public GetBooksResponse getBooks(String publishingHouseName) {
		if(publishingHouseName != null) {
			return service.findAllByPublishingHouse(publishingHouseName)
					.map(booksToResponse)
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		} else {
			return booksToResponse.apply(service.findAll());
		}
	}

	@Override
	public GetBookResponse getBook(UUID id) {
		return service.find(id)
				.map(bookToResponse)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@Override
	public void putBook(UUID id, PutBookRequest request) {
		try {
			service.create(requestToBook.apply(id, request));
		} catch (BookServiceException exception) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
		}
	}

	@Override
	public void patchBook(UUID id, PatchBookRequest request) {
		service.find(id)
				.ifPresentOrElse(
						book -> {
							try {
								service.update(updateBookWithRequest.apply(book, request));
							} catch (BookServiceException error) {
								throw new ResponseStatusException(HttpStatus.BAD_REQUEST, error.getMessage());
							}
						},
						() -> {
							throw new ResponseStatusException(HttpStatus.NOT_FOUND);
						}
				);
	}

	@Override
	public void deleteBook(UUID id) {
		service.find(id)
				.ifPresentOrElse(
						character -> service.delete(id),
						() -> {
							throw new ResponseStatusException(HttpStatus.NOT_FOUND);
						}
				);
	}
}
