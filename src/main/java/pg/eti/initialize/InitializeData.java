package pg.eti.initialize;

import pg.eti.book.entity.Book;
import pg.eti.book.entity.PublishingHouse;

import java.util.*;

public class InitializeData {

	public Collection<PublishingHouse> initializeData() {
		Collection<PublishingHouse> publishingHouses = new ArrayList<>();
		publishingHouses.add(createSiedmiorogPublishingHouse());
		publishingHouses.add(createInsignisPublishingHouse());
		return publishingHouses;
	}

	private PublishingHouse createInsignisPublishingHouse() {
		List<Book> books = new ArrayList<>();

		PublishingHouse publishingHouse = PublishingHouse.builder()
				.name("Insignis")
				.creationYear(2007)
				.books(books)
				.build();

		Book dzienSmokaBook = Book.builder()
				.author("Richard A. Knaak")
				.ISBN("9788367323000")
				.genres(new ArrayList<>(Arrays.asList("Fantasy", "Fiction")))
				.publishingHouse(publishingHouse)
				.title("World of Warcraft: Dzień smoka")
				.numberOfPages(374)
				.build();
		books.add(dzienSmokaBook);

		Book jainaProudmooreBook = Book.builder()
				.author("Christie Golden")
				.ISBN("9788366575967")
				.genres(new ArrayList<>(Arrays.asList("Fantasy", "Science Fiction")))
				.publishingHouse(publishingHouse)
				.title("World of Warcraft: Jaina Proudmoore. Wichry wojny")
				.numberOfPages(396)
				.build();
		books.add(jainaProudmooreBook);

		return publishingHouse;
	}

	private PublishingHouse createSiedmiorogPublishingHouse() {
		List<Book> books = new ArrayList<>();

		PublishingHouse publishingHouse = PublishingHouse.builder()
				.name("Siedmioróg")
				.creationYear(1990)
				.books(books)
				.build();

		Book syzyfowePraceBook = Book.builder()
				.author("Stefan Żeromski")
				.ISBN("9788377916148")
				.genres(new ArrayList<>(Arrays.asList("Novel", "Fiction")))
				.publishingHouse(publishingHouse)
				.title("Syzyfowe Prace")
				.numberOfPages(192)
				.build();
		books.add(syzyfowePraceBook);

		Book kamiennaPulapkaBook = Book.builder()
				.author("Krzysztof Petek")
				.ISBN("9788382797190")
				.genres(new ArrayList<>(List.of("Crime novel")))
				.publishingHouse(publishingHouse)
				.title("Kamienna Pułapka")
				.numberOfPages(164)
				.build();
		books.add(kamiennaPulapkaBook);

		return publishingHouse;
	}
}
