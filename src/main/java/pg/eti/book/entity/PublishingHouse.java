package pg.eti.book.entity;

import jakarta.persistence.*;
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

	@Column(unique = true)
	private String name;

	private Integer creationYear;

	@OneToMany(mappedBy = "publishingHouse", cascade = CascadeType.REMOVE)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private List<Book> books;
}
