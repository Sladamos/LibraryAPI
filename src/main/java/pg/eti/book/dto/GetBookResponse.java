package pg.eti.book.dto;

import lombok.Builder;
import lombok.ToString;

import java.util.List;

@Builder
@ToString
public class GetBookResponse {

	private String title;

	private String ISBN;

	private String author;

	private int numberOfPages;

	private List<String> genres;

	private String publishingHouse;
}
