package pg.eti.book.function;

import org.springframework.stereotype.Component;
import pg.eti.book.dto.GetBooksResponse;
import pg.eti.book.entity.Book;

import java.util.List;
import java.util.function.Function;

@Component
public class BooksToResponseFunction implements Function<List<Book>, GetBooksResponse> {

	@Override
	public GetBooksResponse apply(List<Book> bookList) {
		return GetBooksResponse.builder()
				.books(bookList.stream()
						.map(book -> GetBooksResponse.Book.builder()
								.title(book.getTitle())
								.author(book.getAuthor())
								.build())
						.toList())
				.build();
	}
}
