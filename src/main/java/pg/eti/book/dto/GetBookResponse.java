package pg.eti.book.dto;

import pg.eti.book.entity.PublishingHouse;

import java.util.List;

public class GetBookResponse {

	private String title;

	private String author;

	private int numberOfPages;

	private List<String> genres;

	private String publishingHouse;
}
