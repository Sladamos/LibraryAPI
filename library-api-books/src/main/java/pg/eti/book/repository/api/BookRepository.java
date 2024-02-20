package pg.eti.book.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pg.eti.book.entity.Book;
import pg.eti.publishinghouse.entity.PublishingHouse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {

    List<Book> findAllByPublishingHouse(PublishingHouse publishingHouse);

	Optional<Book> findByIsbn(String isbn);
}
