package pg.eti.book.service.api;

import pg.eti.book.entity.PublishingHouse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PublishingHouseService {

    Optional<PublishingHouse> find(UUID id);

    List<PublishingHouse> findAll();

    void create(PublishingHouse publishingHouse);

    void update(PublishingHouse publishingHouse);

    void update(List<PublishingHouse> publishingHouses);

    void delete(UUID publishingHouse);

    void deleteAll();
}
