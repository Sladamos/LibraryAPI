package pg.eti.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pg.eti.book.entity.PublishingHouse;
import pg.eti.book.repository.api.PublishingHouseRepository;
import pg.eti.book.service.api.PublishingHouseService;

import java.util.Optional;
import java.util.UUID;

public class PublishingHouseServiceImpl implements PublishingHouseService {

    private final PublishingHouseRepository repository;

    @Autowired
    public PublishingHouseServiceImpl(PublishingHouseRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<PublishingHouse> find(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void create(PublishingHouse publishingHouse) {
        repository.save(publishingHouse);
    }
}
