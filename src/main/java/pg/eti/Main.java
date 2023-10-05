package pg.eti;

import pg.eti.book.entity.Book;
import pg.eti.book.entity.PublishingHouse;
import pg.eti.initialize.InitializeData;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		InitializeData initializeData = new InitializeData();
		Collection<PublishingHouse> publishingHouses = initializeData.initializeData();
		publishingHouses.forEach(System.out::println);
		Set<Book> bookSet = taskWithSet(publishingHouses);
	}

	private static Set<Book> taskWithSet(Collection<PublishingHouse> publishingHouses) {
		Set<Book> bookSet = publishingHouses.stream()
				.flatMap(el -> el.getBooks().stream())
				.collect(Collectors.toSet());
		bookSet.stream().forEach(System.out::println);
		return bookSet;
	}

	private static void taskWithFilter() {

	}

	private static void taskWithDTO() {

	}

	private static void taskWithSerialization() {

	}

	private static void taskWithParallel() {

	}
}