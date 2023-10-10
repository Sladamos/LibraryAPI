package pg.eti.book.function;

import org.springframework.stereotype.Component;
import pg.eti.book.dto.GetBookResponse;
import pg.eti.book.entity.Book;

import java.util.function.Function;

@Component
public class BookToResponseFunction implements Function<Book, GetBookResponse> {

	@Override
	public GetBookResponse apply(Book book) {
		return GetBookResponse.builder()
				.id(book.getId())
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
