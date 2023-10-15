package pg.eti.publishinghouse.event.repository.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import pg.eti.publishinghouse.entity.PublishingHouse;
import pg.eti.publishinghouse.event.repository.api.PublishingHouseEventRepository;

import java.util.UUID;

@Repository
public class PublishingHouseEventRestRepository implements PublishingHouseEventRepository {

    private final RestTemplate restTemplate;

    @Autowired
    public PublishingHouseEventRestRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void delete(UUID id) {
        restTemplate.delete("/api/publishing-houses/{id}", id);
    }

    @Override
    public void create(PublishingHouse publishingHouse) {
        //restTemplate.put("/api/publishing-houses/{id}", publishingHouse);
    }

    @Override
    public void update(PublishingHouse publishingHouse) {
        //restTemplate.patch("/api/publishing-houses/{id}", publishingHouse);
    }
}
