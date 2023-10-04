package pg.eti.book.entity.impl;

import lombok.*;
import lombok.experimental.SuperBuilder;
import pg.eti.literature.entity.Literature;

import java.util.List;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Book extends Literature {

	private String author;

	private String ISBN;

	private List<String> genres;

	private PublishingHouse publishingHouse;
}
