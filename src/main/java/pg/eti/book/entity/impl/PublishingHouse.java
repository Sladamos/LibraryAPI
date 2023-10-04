package pg.eti.book.entity.impl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import pg.eti.literature.api.LiteraturePublisher;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PublishingHouse implements LiteraturePublisher {

	private String name;

	private int creationYear;

	private List<Book> books;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getPublisherInfo());
		return builder.toString();
		//builder.append()
	}

	@Override
	public String getPublisherInfo() {
		return String.format("PublishingHouse(name=%s, creationYear=%d)",
				name, creationYear);
	}
}
