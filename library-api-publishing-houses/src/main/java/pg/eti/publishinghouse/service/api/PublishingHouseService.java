package pg.eti.publishinghouse.service.api;

import pg.eti.publishinghouse.entity.PublishingHouse;
import pg.eti.publishinghouse.service.exception.PublishingHouseServiceException;

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
