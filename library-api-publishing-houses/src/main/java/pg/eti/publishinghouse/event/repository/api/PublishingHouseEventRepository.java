package pg.eti.publishinghouse.event.repository.api;

import pg.eti.publishinghouse.entity.PublishingHouse;

import java.util.UUID;

public interface PublishingHouseEventRepository {

    void delete(UUID id);

    void create(PublishingHouse publishingHouse);

    void update(PublishingHouse publishingHouse);
}
