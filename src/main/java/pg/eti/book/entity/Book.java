package pg.eti.book.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import pg.eti.literature.entity.Literature;

import java.util.List;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Book extends Literature {

	private String author;

	private String ISBN;

	private List<String> genres;

	private PublishingHouse publishingHouse;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		String invulnerableInfo = getInvulnerableInfo();
		builder.append(invulnerableInfo, 0, invulnerableInfo.length() - 1);
		builder.append(", publishingHouse=");
		builder.append(publishingHouse.getInvulnerableInfo());
		builder.append(")");
		return builder.toString();
	}

	@Override
	public String getInvulnerableInfo() {
		return String.format("Book(super=%s, author=%s, ISBN=%s, genres=%s)"
		, super.toString(), author, ISBN, genres);
	}
}
