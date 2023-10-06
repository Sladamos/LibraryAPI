package pg.eti;

import pg.eti.book.dto.GetBookResponse;
import pg.eti.book.entity.Book;
import pg.eti.book.entity.PublishingHouse;
import pg.eti.book.function.BookToResponseFunction;
import pg.eti.initialize.InitializeData;
import pg.eti.literature.entity.Literature;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		InitializeData initializeData = new InitializeData();
		Collection<PublishingHouse> publishingHouses = initializeData.initializeData();
		publishingHouses.forEach(System.out::println);
		Set<Book> bookSet = taskWithSet(publishingHouses);
		taskWithFilter(bookSet);
		taskWithDTO(bookSet);
		//TODO natural order?
	}

	private static Set<Book> taskWithSet(Collection<PublishingHouse> publishingHouses) {
		System.out.println("Task with set");
		Set<Book> bookSet = publishingHouses.stream()
				.flatMap(el -> el.getBooks().stream())
				.collect(Collectors.toSet());
		bookSet.forEach(System.out::println);
		return bookSet;
	}

	private static void taskWithFilter(Collection<Book> bookCollection) {
		System.out.println("Task with filter");
		bookCollection.stream()
				.filter(el -> el.getNumberOfPages() % 3 == 0)
				.sorted(Comparator.comparing(Literature::getTitle))
				.forEach(System.out::println);
	}

	private static Collection<GetBookResponse> taskWithDTO(Collection<Book> bookCollection) {
		BookToResponseFunction dtoFunction = new BookToResponseFunction();
		List<GetBookResponse> bookResponses = bookCollection.stream()
				.map(dtoFunction)
				.toList();
		bookResponses.forEach(System.out::println);
		return bookResponses;
	}

	private static void taskWithSerialization() {
		System.out.println("Task with serialization");
	}

	private static void taskWithParallel() {
		System.out.println("Parallel task");

	}
}