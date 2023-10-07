package pg.eti.book.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import pg.eti.literature.api.InvulnerableInformer;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "publishing_houses")
public class PublishingHouse implements InvulnerableInformer, Serializable {

	@Id
	private UUID id;

	private String name;

	private int creationYear;

	@OneToMany(mappedBy = "publishingHouse")
	@EqualsAndHashCode.Exclude
	private List<Book> books;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		String invulnerableInfo = getInvulnerableInfo();
		builder.append(invulnerableInfo, 0, invulnerableInfo.length() - 1);
		builder.append(", ");
		String booksInfo = getInfoAboutBooks(")");
		builder.append(booksInfo);
		return builder.toString();
	}

	private String getInfoAboutBooks(String suffix) {
		return books.stream()
				.map(Book::getInvulnerableInfo)
				.collect(Collectors.joining("\n\t", "books=\n\t", suffix));
	}

	@Override
	public String getInvulnerableInfo() {
		return String.format("PublishingHouse(name=%s, creationYear=%d)",
				name, creationYear);
	}
}
