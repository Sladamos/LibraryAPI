package pg.eti.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pg.eti.book.entity.Book;
import pg.eti.book.entity.PublishingHouse;
import pg.eti.book.repository.api.BookRepository;
import pg.eti.book.repository.api.PublishingHouseRepository;
import pg.eti.book.service.api.BookService;
import pg.eti.book.service.exception.BookServiceException;

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
        if (book.getIsbn() == null) {
            throw new BookServiceException("ISBN is not specified");
        }
        if (book.getPublishingHouse().getId() == null) {
            throw new BookServiceException("Publishing house is not specified");
        }

        Optional<PublishingHouse> publishingHouse = publishingHouseRepository.findById(book.getPublishingHouse().getId());
        if (publishingHouse.isEmpty()) {
            throw new BookServiceException("Publishing house doesn't exist");
        }
        Optional<Book> bookWithSameIsbn = repository.findByIsbn(book.getIsbn());

        if (bookWithSameIsbn.isPresent() && !bookWithSameIsbn.get().getId().equals(book.getId())) {
            throw new BookServiceException("ISBN is already used");
        }

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
