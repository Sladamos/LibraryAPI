package pg.eti.book.entity.impl;

import lombok.*;
import lombok.experimental.SuperBuilder;
import pg.eti.literature.entity.Literature;

import java.util.List;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Book extends Literature {

	private String author;

	private String ISBN;

	private List<String> genres;

	private PublishingHouse publishingHouse;
//
//	@Override
//	public String toString() {
//		return String.format("Book(author=%s, ISBN=%s, genres=%s,  publishingHouse=%s )",
//				name, creationYear);
//	}
}
