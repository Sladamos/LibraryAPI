package pg.eti.book.service.api;

import pg.eti.book.entity.Book;
import pg.eti.book.entity.PublishingHouse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookService {
    List<Book> findAll();
    Optional<Book> find(UUID id);
    Optional<Book> find(PublishingHouse publishingHouse, UUID id);
    Optional<List<Book>> findAllByPublishingHouse(PublishingHouse publishingHouse);
    void create(Book book);
    void update(Book book);
    void delete(UUID id);
}
