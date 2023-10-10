package pg.eti.book.function;

import pg.eti.book.dto.PutBookRequest;
import pg.eti.book.entity.Book;
import pg.eti.book.entity.PublishingHouse;

import java.util.UUID;
import java.util.function.BiFunction;

public class PutRequestToBookFunction implements BiFunction<UUID, PutBookRequest, Book> {

	@Override
	public Book apply(UUID id, PutBookRequest putBookRequest) {
		return Book.builder()
				.id(id)
				.author(putBookRequest.getAuthor())
				.title(putBookRequest.getTitle())
				.isbn(putBookRequest.getIsbn())
				.numberOfPages(putBookRequest.getNumberOfPages())
				.genres(putBookRequest.getGenres())
				.publishingHouse(PublishingHouse.builder()
						.id(putBookRequest.getPublishingHouse())
						.build())
				.build();
	}
}
