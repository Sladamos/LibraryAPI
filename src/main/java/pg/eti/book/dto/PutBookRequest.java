package pg.eti.book.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class PutBookRequest {

	private UUID id;

	private String author;

	private String title;

	private String isbn;

	private int numberOfPages;

	private List<String> genres;

}
