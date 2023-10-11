package pg.eti.book.service.api;

import pg.eti.book.entity.PublishingHouse;
import pg.eti.book.service.exception.PublishingHouseServiceException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PublishingHouseService {

    Optional<PublishingHouse> find(UUID id);

    List<PublishingHouse> findAll();

    void create(PublishingHouse publishingHouse) throws PublishingHouseServiceException;

    void update(PublishingHouse publishingHouse) throws PublishingHouseServiceException;

    void delete(UUID publishingHouse);

    void deleteAll();
}
