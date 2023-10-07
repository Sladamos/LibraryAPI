package pg.eti.book.service.api;

import pg.eti.book.entity.Book;
import pg.eti.book.entity.PublishingHouse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookService {

    Optional<Book> find(UUID id);

    Optional<Book> find(PublishingHouse publishingHouse, UUID id);

    List<Book> findAll();

    Optional<List<Book>> findAllByPublishingHouse(UUID publishingHouseId);

    void create(Book book);

    void update(Book book);

    void delete(UUID id);
}
