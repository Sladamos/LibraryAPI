package pg.eti.book.service.api;

import pg.eti.book.entity.PublishingHouse;

import java.util.Optional;
import java.util.UUID;

public interface PublishingHouseService {
    Optional<PublishingHouse> find(UUID id);
    void create(PublishingHouse publishingHouse);
}
