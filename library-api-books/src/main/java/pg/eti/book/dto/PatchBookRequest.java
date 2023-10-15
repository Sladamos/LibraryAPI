package pg.eti.book.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PatchBookRequest {

	private String author;

	private String title;

	private String isbn;

	private Integer numberOfPages;

}
