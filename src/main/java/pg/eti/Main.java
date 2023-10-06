package pg.eti;

import pg.eti.book.dto.GetBookResponse;
import pg.eti.book.entity.Book;
import pg.eti.book.entity.PublishingHouse;
import pg.eti.book.function.BookToResponseFunction;
import pg.eti.initialize.InitializeData;
import pg.eti.literature.entity.Literature;
import pg.eti.serialization.FileSerializer;
import pg.eti.serialization.CollectionsSerializerImpl;

import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		InitializeData initializeData = new InitializeData();
		Collection<PublishingHouse> publishingHouses = initializeData.initializeData();
		publishingHouses.forEach(System.out::println);
		Set<Book> bookSet = taskWithSet(publishingHouses);
		taskWithFilter(bookSet);
		taskWithDTO(bookSet);
		taskWithSerialization(publishingHouses);
		taskWithParallel(publishingHouses);
		//TODO natural order - repair one task
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

	private static void taskWithSerialization(Collection<PublishingHouse> publishingHouses) {
		System.out.println("Task with serialization");
		publishingHouses.forEach(System.out::println);
		FileSerializer publishingHouseFileSerializer = new FileSerializer(new CollectionsSerializerImpl());
		publishingHouseFileSerializer.serializeToFile(publishingHouses, "houses");
		Collection<PublishingHouse> readedHouses = publishingHouseFileSerializer.serializeFromFile("houses");
		System.out.println("Serialization finished");
		readedHouses.forEach(System.out::println);
	}

	private static void taskWithParallel(Collection<PublishingHouse> publishingHouses) {
		//TODO refactor
		System.out.println("Parallel task");
		ForkJoinPool pool = new ForkJoinPool(4);
		pool.submit(() ->
			publishingHouses.parallelStream().forEach(Main::publishingHouseTask));
		pool.shutdown();
		try {
			pool.awaitTermination(30, TimeUnit.SECONDS);
		} catch (InterruptedException ignored) {
		}
	}

	private static void publishingHouseTask(PublishingHouse publishingHouse) {
		for(int i = 0; i < 3; i++) {
			System.out.println(publishingHouse);
			double delay = Math.random() * 2000;
			try {
				Thread.sleep((long) delay);
				System.out.println("Iteration ended, I am" + publishingHouse.getInvulnerableInfo());
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}