package pg.eti.book.function;

import pg.eti.book.dto.GetBookResponse;
import pg.eti.book.entity.Book;

import java.util.function.Function;

public class BookToResponseFunction implements Function<Book, GetBookResponse> {
	@Override
	public GetBookResponse apply(Book book) {
		return GetBookResponse.builder()
				.author(book.getAuthor())
				.title(book.getTitle())
				.ISBN(book.getISBN())
				.genres(book.getGenres())
				.publishingHouse(book.getPublishingHouse().getName())
				.numberOfPages(book.getNumberOfPages())
				.build();
	}
}
