package pg.eti.book.initialize;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pg.eti.book.entity.Book;
import pg.eti.book.service.api.BookService;
import pg.eti.publishinghouse.entity.PublishingHouse;
import pg.eti.publishinghouse.service.api.PublishingHouseService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {

	private final BookService bookService;

	private final PublishingHouseService publishingHouseService;

	@Autowired
	public InitializeData(BookService bookService, PublishingHouseService publishingHouseService) {
		this.bookService = bookService;
		this.publishingHouseService = publishingHouseService;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if(bookService.findAll().isEmpty()) {
			PublishingHouse insignisPublishingHouse = PublishingHouse.builder()
					.id(UUID.fromString("f5875513-bf7b-4ae1-b8a5-5b70a1b90e76"))
					.name("Insignis")
					.creationYear(2007)
					.build();

			PublishingHouse siedmiorogPublishingHouse = PublishingHouse.builder()
					.id(UUID.fromString("5d1da2ae-6a14-4b6d-8b4f-d117867118d4"))
					.name("Siedmioróg")
					.creationYear(1990)
					.build();

			publishingHouseService.create(insignisPublishingHouse);
			publishingHouseService.create(siedmiorogPublishingHouse);

			Book dragonDayBook = Book.builder()
					.id(UUID.fromString("525d3e7b-bb1f-4c13-bf17-926d1a12e4c0"))
					.author("Richard A. Knaak")
					.isbn("9788367323000")
					.genres(new ArrayList<>(Arrays.asList("Fantasy", "Fiction")))
					.publishingHouse(insignisPublishingHouse)
					.title("World of Warcraft: Dzień smoka")
					.numberOfPages(374)
					.build();

			Book jainaProudmooreBook = Book.builder()
					.id(UUID.fromString("cc0b0577-bb6f-45b7-81d6-3db88e6ac19f"))
					.author("Christie Golden")
					.isbn("9788366575967")
					.genres(new ArrayList<>(Arrays.asList("Fantasy", "Science Fiction")))
					.publishingHouse(insignisPublishingHouse)
					.title("World of Warcraft: Jaina Proudmoore. Wichry wojny")
					.numberOfPages(396)
					.build();

			Book riseOfTheLichKingBook = Book.builder()
					.id(UUID.fromString("f08ef7e3-7f2a-4378-b1fb-2922d730c70d"))
					.author("Christie Golden")
					.isbn("9788365743251")
					.genres(new ArrayList<>(Arrays.asList("Fantasy", "Science Fiction")))
					.publishingHouse(insignisPublishingHouse)
					.title("World of Warcraft: Arthas. Przebudzenie Króla Lisza")
					.numberOfPages(368)
					.build();

			Book laborsOfSisyphusBook = Book.builder()
					.id(UUID.fromString("ff327e8a-77c0-4f9b-90a2-89e16895d1e1"))
					.author("Stefan Żeromski")
					.isbn("9788377916148")
					.genres(new ArrayList<>(Arrays.asList("Novel", "Fiction")))
					.publishingHouse(siedmiorogPublishingHouse)
					.title("Syzyfowe Prace")
					.numberOfPages(192)
					.build();

			Book stoneTrapBook = Book.builder()
					.id(UUID.fromString("2d9b1e8c-67c5-4188-a911-5f064a63d8cd"))
					.author("Krzysztof Petek")
					.isbn("9788382797190")
					.genres(new ArrayList<>(List.of("Crime novel")))
					.publishingHouse(siedmiorogPublishingHouse)
					.title("Kamienna Pułapka")
					.numberOfPages(164)
					.build();

			bookService.create(dragonDayBook);
			bookService.create(jainaProudmooreBook);
			bookService.create(riseOfTheLichKingBook);
			bookService.create(laborsOfSisyphusBook);
			bookService.create(stoneTrapBook);
		}
	}
}
