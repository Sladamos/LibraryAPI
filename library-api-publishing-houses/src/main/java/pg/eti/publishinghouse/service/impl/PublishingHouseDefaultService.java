package pg.eti.publishinghouse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pg.eti.publishinghouse.entity.PublishingHouse;
import pg.eti.publishinghouse.event.repository.api.PublishingHouseEventRepository;
import pg.eti.publishinghouse.repository.api.PublishingHouseRepository;
import pg.eti.publishinghouse.service.api.PublishingHouseService;
import pg.eti.publishinghouse.service.exception.PublishingHouseServiceException;
import pg.eti.publishinghouse.validator.api.PublishingHouseNameValidator;
import pg.eti.publishinghouse.validator.exception.ValidatorException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PublishingHouseDefaultService implements PublishingHouseService {

    private final PublishingHouseRepository repository;

    private final PublishingHouseEventRepository eventRepository;

    private final PublishingHouseNameValidator nameValidator;

    @Autowired
    public PublishingHouseDefaultService(
            PublishingHouseRepository repository,
            PublishingHouseEventRepository eventRepository,
            PublishingHouseNameValidator nameValidator) {
        this.repository = repository;
        this.eventRepository = eventRepository;
        this.nameValidator = nameValidator;
    }

    @Override
    public Optional<PublishingHouse> find(UUID id) {
        return repository.findById(id);
    }

    @Override
    public List<PublishingHouse> findAll() {
        return repository.findAll();
    }

    @Override
    public void create(PublishingHouse publishingHouse) throws PublishingHouseServiceException {
        checkIfNameIsSpecified(publishingHouse.getName());
        checkIfNameIsNotBeingReservedByOtherPublishingHouse(publishingHouse.getName(), publishingHouse.getId());
        try {
            nameValidator.validateName(publishingHouse.getName());
        } catch (ValidatorException e) {
            throw new PublishingHouseServiceException(e.getMessage());
        }
        repository.save(publishingHouse);
        eventRepository.create(publishingHouse);
    }

    @Override
    public void update(PublishingHouse publishingHouse) throws PublishingHouseServiceException {
        checkIfNameIsNotBeingReservedByOtherPublishingHouse(publishingHouse.getName(), publishingHouse.getId());
        try {
            nameValidator.validateName(publishingHouse.getName());
        } catch (ValidatorException e) {
            throw new PublishingHouseServiceException(e.getMessage());
        }
        repository.save(publishingHouse);
        eventRepository.update(publishingHouse);
    }

    @Override
    public void delete(UUID publishingHouse) {
        repository.findById(publishingHouse).ifPresent(repository::delete);
        eventRepository.delete(publishingHouse);
    }

    private void checkIfNameIsSpecified(String name) throws PublishingHouseServiceException {
        if (name == null) {
            throw new PublishingHouseServiceException("Name is not specified");
        }
    }

    private void checkIfNameIsNotBeingReservedByOtherPublishingHouse(String name, UUID id) throws PublishingHouseServiceException {
        Optional<PublishingHouse> publishingHouseWithSameName = repository.findByName(name);

        if (publishingHouseWithSameName.isPresent() &&
                !publishingHouseWithSameName.get().getId().equals(id)) {
            throw new PublishingHouseServiceException("Name is already reserved");
        }
    }
}
