package pg.eti.book.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@ToString
@Table(name = "publishing_houses")
public class PublishingHouse implements Serializable {

	@Id
	private UUID id;

	private String name;

	private int creationYear;

	@OneToMany(mappedBy = "publishingHouse")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private List<Book> books;
}
