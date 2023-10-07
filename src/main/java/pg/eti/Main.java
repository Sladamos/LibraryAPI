package pg.eti;

import pg.eti.book.comparator.GetBookResponseComparator;
import pg.eti.book.dto.GetBookResponse;
import pg.eti.book.entity.Book;
import pg.eti.book.entity.PublishingHouse;
import pg.eti.book.function.BookToResponseFunction;
import pg.eti.book.task.PublishingHouseTask;
import pg.eti.book.task.SelfPrintablePublishingHouseTask;
import pg.eti.initialize.InitializeData;
import pg.eti.literature.entity.Literature;
import pg.eti.parallel.ParallelTaskExecutioner;
import pg.eti.parallel.ParallelTaskExecutionerImpl;
import pg.eti.serialization.CollectionsSerializerImpl;
import pg.eti.serialization.FileSerializer;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
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

	private static void taskWithDTO(Collection<Book> bookCollection) {
		System.out.println("Task with DTO");
		BookToResponseFunction dtoFunction = new BookToResponseFunction();
		List<GetBookResponse> bookResponses = bookCollection.stream()
				.map(dtoFunction)
				.sorted(new GetBookResponseComparator())
				.toList();
		bookResponses.forEach(System.out::println);
	}

	private static void taskWithSerialization(Collection<PublishingHouse> publishingHouses) {
		System.out.println("Task with serialization");
		publishingHouses.forEach(System.out::println);
		FileSerializer publishingHouseFileSerializer = FileSerializer.builder()
				.collectionsSerializer(new CollectionsSerializerImpl())
				.build();
		publishingHouseFileSerializer.serializeToFile(publishingHouses, "houses");
		Collection<PublishingHouse> readHouses = publishingHouseFileSerializer.serializeFromFile("houses");
		System.out.println("Serialization finished");
		readHouses.forEach(System.out::println);
	}

	private static void taskWithParallel(Collection<PublishingHouse> publishingHouses) {
		System.out.println("Parallel task");
		ParallelTaskExecutioner executioner = new ParallelTaskExecutionerImpl();
		Supplier<PublishingHouseTask> publishingHouseTaskGenerator = createPublishingHouseTasksGenerator();
		executioner.submit(() ->
			publishingHouses.parallelStream().forEach(publishingHouseTaskGenerator.get()));
		executioner.shutdown();
		executioner.awaitTermination(30, TimeUnit.SECONDS);
	}

	private static Supplier<PublishingHouseTask> createPublishingHouseTasksGenerator() {
		return  () -> SelfPrintablePublishingHouseTask.builder()
				.maxDelayInMilliseconds(2000)
				.numberOfIterations(3)
				.build();
	}
}