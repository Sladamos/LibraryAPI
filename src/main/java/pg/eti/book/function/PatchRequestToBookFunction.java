package pg.eti.book.function;

import pg.eti.book.dto.PatchBookRequest;
import pg.eti.book.entity.Book;

import java.util.UUID;
import java.util.function.BiFunction;

public class PatchRequestToBookFunction implements BiFunction<UUID, PatchBookRequest, Book> {

	@Override
	public Book apply(UUID id, PatchBookRequest patchBookRequest) {
		return Book.builder()
				.id(id)
				.title(patchBookRequest.getTitle())
				.author(patchBookRequest.getAuthor())
				.isbn(patchBookRequest.getIsbn())
				.numberOfPages(patchBookRequest.getNumberOfPages())
				.build();
	}
}
