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
				.title(patchBookRequest.getTitle() == null ? entity.getTitle() : patchBookRequest.getTitle())
				.author(patchBookRequest.getAuthor() == null ? entity.getAuthor() : patchBookRequest.getAuthor())
				.isbn(patchBookRequest.getIsbn() == null ? entity.getIsbn() : patchBookRequest.getIsbn())
				.numberOfPages(patchBookRequest.getNumberOfPages() == null ?
						entity.getNumberOfPages() : patchBookRequest.getNumberOfPages())
				.genres(entity.getGenres())
				.publishingHouse(entity.getPublishingHouse())
				.build();
	}
}
