package pg.eti.book.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class GetBooksResponse {

	@Data
	@Builder
	public static class Book {

		private final UUID id;

		private final String title;

		private final String author;
	}

	@Singular
	private List<Book> books;
}
