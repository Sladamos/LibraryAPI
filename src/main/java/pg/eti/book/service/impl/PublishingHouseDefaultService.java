package pg.eti.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pg.eti.book.entity.PublishingHouse;
import pg.eti.book.repository.api.PublishingHouseRepository;
import pg.eti.book.service.api.PublishingHouseService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PublishingHouseDefaultService implements PublishingHouseService {

    private final PublishingHouseRepository repository;

    @Autowired
    public PublishingHouseDefaultService(PublishingHouseRepository repository) {
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

    @Override
    public List<PublishingHouse> findAll() {
        return repository.findAll();
    }
}
