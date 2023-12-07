package pg.eti.publishinghouse.event.repository.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import pg.eti.publishinghouse.entity.PublishingHouse;
import pg.eti.publishinghouse.event.repository.api.PublishingHouseEventRepository;

import java.net.URI;
import java.util.UUID;

@Repository
public class PublishingHouseEventRestRepository implements PublishingHouseEventRepository {

    private final LoadBalancerClient loadBalancerClient;

    private final RestTemplate restTemplate;

    @Autowired
    public PublishingHouseEventRestRepository(LoadBalancerClient loadBalancerClient, RestTemplate restTemplate) {
        this.loadBalancerClient = loadBalancerClient;
        this.restTemplate = restTemplate;
    }

    @Override
    public void delete(UUID id) {
        try {
            URI uri = loadBalancerClient.choose("library-api-books").getUri();
            restTemplate.delete( uri +"/api/publishing-houses/" + id);
        } catch (Exception e) {
            System.out.println("Other service is disabled");
        }
    }

    @Override
    public void create(PublishingHouse publishingHouse) {
        try {
            URI uri = loadBalancerClient.choose("library-api-books").getUri();
            restTemplate.put(uri +"/api/publishing-houses/" + publishingHouse.getId(),
                    publishingHouse);
        } catch (Exception e) {
            System.out.println("Other service is disabled");
        }
    }

    @Override
    public void update(PublishingHouse publishingHouse) {
        try {
            URI uri = loadBalancerClient.choose("library-api-books").getUri();
            restTemplate.put(uri +"/api/publishing-houses/" + publishingHouse.getId(),
                    publishingHouse);
        } catch (Exception e) {
            System.out.println("Other service is disabled");
        }
    }
}
