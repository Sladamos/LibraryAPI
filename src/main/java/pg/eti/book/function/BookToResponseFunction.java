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
				.ISBN(book.getIsbn())
				.genres(book.getGenres())
				.publishingHouse(GetBookResponse.PublishingHouse.builder()
						.id(book.getPublishingHouse().getId())
						.name(book.getPublishingHouse().getName())
						.build())
				.numberOfPages(book.getNumberOfPages())
				.build();
	}
}
