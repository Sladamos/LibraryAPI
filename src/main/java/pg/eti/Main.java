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
		Set<Book> bookSet = publishingHouses.stream()
				.flatMap(el -> el.getBooks().stream())
				.collect(Collectors.toSet());
	}
}