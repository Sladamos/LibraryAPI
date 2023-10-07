package pg.eti.book.service.impl;

import pg.eti.book.entity.Book;
import pg.eti.book.entity.PublishingHouse;
import pg.eti.book.service.api.BookService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class BookDefaultService implements BookService {

    private final

    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public Optional<Book> find(UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<Book> find(PublishingHouse publishingHouse, UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Book>> findAllByPublishingHouse(PublishingHouse publishingHouse) {
        return Optional.empty();
    }

    @Override
    public void create(Book book) {

    }

    @Override
    public void update(Book book) {

    }

    @Override
    public void delete(UUID id) {

    }
}
