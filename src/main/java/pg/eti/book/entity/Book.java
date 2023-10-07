package pg.eti.book.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;
import pg.eti.literature.entity.Literature;

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

	private String ISBN;

	private List<String> genres;

	@ManyToOne
	@JoinColumn(name = "publishing_house")
	private PublishingHouse publishingHouse;
}
