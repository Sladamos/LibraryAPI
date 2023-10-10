package pg.eti.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pg.eti.book.entity.Book;
import pg.eti.book.repository.api.BookRepository;
import pg.eti.book.repository.api.PublishingHouseRepository;
import pg.eti.book.service.api.BookService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookDefaultService implements BookService {

    private final BookRepository repository;

    private final PublishingHouseRepository publishingHouseRepository;

    @Autowired
    public BookDefaultService(BookRepository repository, PublishingHouseRepository publishingHouseRepository) {
        this.repository = repository;
        this.publishingHouseRepository = publishingHouseRepository;
    }

    @Override
    public Optional<Book> find(UUID id) {
        return repository.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<List<Book>> findAllByPublishingHouse(UUID publishingHouseId) {
        return publishingHouseRepository.findById(publishingHouseId)
                .map(repository::findAllByPublishingHouse);
    }

    @Override
    public Optional<List<Book>> findAllByPublishingHouse(String publishingHouseName) {
        return publishingHouseRepository.findByName(publishingHouseName)
                .map(repository::findAllByPublishingHouse);
    }

    @Override
    public void create(Book book) {
        repository.save(book);
    }

    @Override
    public void update(Book book) {
        repository.save(book);
    }

    @Override
    public void update(List<Book> books) {
        repository.saveAll(books);
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
