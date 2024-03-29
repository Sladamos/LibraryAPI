package pg.eti.book.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import pg.eti.literature.entity.Literature;
import pg.eti.publishinghouse.entity.PublishingHouse;

import java.util.List;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@ToString(callSuper = true)
@Table(name = "books")
public class Book extends Literature {

	private String author;

	@Column(unique = true)
	private String isbn;

	private List<String> genres;

	@ManyToOne
	@JoinColumn(name = "publishing_house_id")
	private PublishingHouse publishingHouse;
}
