package pg.eti.book.function;

import org.springframework.stereotype.Component;
import pg.eti.book.dto.PatchBookRequest;
import pg.eti.book.entity.Book;

import java.util.function.BiFunction;

@Component
public class UpdateBookWithRequestFunction implements BiFunction<Book, PatchBookRequest, Book> {

	@Override
	public Book apply(Book entity, PatchBookRequest patchBookRequest) {
		return Book.builder()
				.id(entity.getId())
				.title(patchBookRequest.getTitle())
				.author(patchBookRequest.getAuthor())
				.isbn(patchBookRequest.getIsbn())
				.numberOfPages(patchBookRequest.getNumberOfPages())
				.genres(entity.getGenres())
				.publishingHouse(entity.getPublishingHouse())
				.build();
	}
}
