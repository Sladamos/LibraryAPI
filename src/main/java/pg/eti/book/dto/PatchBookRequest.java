package pg.eti.book.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PatchBookRequest {

	private String author;

	private String title;

	private String isbn;

	private int numberOfPages;

	private List<String> genres;

}
