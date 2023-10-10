package pg.eti.book.service.api;

import pg.eti.book.entity.Book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookService {

    List<Book> findAll();

    Optional<List<Book>> findAllByPublishingHouse(UUID publishingHouseId);

    Optional<List<Book>> findAllByPublishingHouse(String publishingHouseName);

    Optional<Book> find(UUID id);

    void create(Book book);

    void update(Book book);

    void delete(UUID id);

    void deleteAll();
}
