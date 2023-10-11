package pg.eti.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pg.eti.book.entity.Book;
import pg.eti.book.entity.PublishingHouse;
import pg.eti.book.repository.api.BookRepository;
import pg.eti.book.repository.api.PublishingHouseRepository;
import pg.eti.book.service.api.BookService;
import pg.eti.book.service.exception.BookServiceException;
import pg.eti.book.validator.api.IsbnValidator;
import pg.eti.book.validator.exception.ValidatorException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookDefaultService implements BookService {

    private final BookRepository repository;

    private final PublishingHouseRepository publishingHouseRepository;

    private final IsbnValidator isbnValidator;

    @Autowired
    public BookDefaultService(
            BookRepository repository,
            PublishingHouseRepository publishingHouseRepository,
            IsbnValidator isbnValidator) {
        this.repository = repository;
        this.publishingHouseRepository = publishingHouseRepository;
        this.isbnValidator = isbnValidator;
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
    public void create(Book book) throws BookServiceException {
        checkIfIsbnIsSpecified(book.getIsbn());
        checkIfPublishingHouseIdIsSpecified(book.getPublishingHouse().getId());
        checkIfPublishingHouseExists(book.getPublishingHouse().getId());
        checkIfIsbnIsNotBeingReservedByOtherBook(book.getIsbn(), book.getId());
        try {
            isbnValidator.validateIsbn(book.getIsbn());
        } catch (ValidatorException e) {
            throw new BookServiceException(e.getMessage());
        }
        repository.save(book);
    }

    @Override
    public void update(Book book) throws BookServiceException {
        checkIfIsbnIsNotBeingReservedByOtherBook(book.getIsbn(), book.getId());
        try {
            isbnValidator.validateIsbn(book.getIsbn());
        } catch (ValidatorException e) {
            throw new BookServiceException(e.getMessage());
        }
        repository.save(book);
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    private void checkIfPublishingHouseIdIsSpecified(UUID id) throws BookServiceException {
        if (id == null) {
            throw new BookServiceException("Publishing house is not specified");
        }
    }

    private void checkIfIsbnIsSpecified(String isbn) throws BookServiceException {
        if (isbn == null) {
            throw new BookServiceException("ISBN is not specified");
        }
    }

    private void checkIfIsbnIsNotBeingReservedByOtherBook(String isbn, UUID id) throws BookServiceException {
        Optional<Book> bookWithSameIsbn = repository.findByIsbn(isbn);

        if (bookWithSameIsbn.isPresent() && !bookWithSameIsbn.get().getId().equals(id)) {
            throw new BookServiceException("ISBN is already reserved");
        }
    }

    private void checkIfPublishingHouseExists(UUID id) throws BookServiceException {
        Optional<PublishingHouse> publishingHouse = publishingHouseRepository.findById(id);
        if (publishingHouse.isEmpty()) {
            throw new BookServiceException("Publishing house doesn't exist");
        }
    }
}
