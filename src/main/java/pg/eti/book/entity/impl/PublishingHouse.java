package pg.eti.book.entity.impl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import pg.eti.literature.api.InvulnerableInformer;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PublishingHouse implements InvulnerableInformer {

	private String name;

	private int creationYear;

	private List<Book> books;

	@Override
	public String toString() {
		String booksInfo = books.stream()
				.map(Book::getInvulnerableInfo)
				.collect(Collectors.joining("\nBooks published by this house:\n", "\n", ""));
		return getInvulnerableInfo() + booksInfo;
	}

	@Override
	public String getInvulnerableInfo() {
		return String.format("PublishingHouse(name=%s, creationYear=%d)",
				name, creationYear);
	}
}
