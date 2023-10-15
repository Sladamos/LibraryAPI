package pg.eti.book.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class GetBookResponse {

	@Data
	@Builder
	public static class PublishingHouse {

		private String name;

		private UUID id;

	}

	private UUID id;

	private String title;

	private String ISBN;

	private String author;

	private Integer numberOfPages;

	private List<String> genres;

	private PublishingHouse publishingHouse;
}
