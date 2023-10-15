package pg.eti.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pg.eti.book.entity.PublishingHouse;
import pg.eti.book.repository.api.PublishingHouseRepository;
import pg.eti.book.service.api.PublishingHouseService;
import pg.eti.book.service.exception.PublishingHouseServiceException;
import pg.eti.book.validator.api.PublishingHouseNameValidator;
import pg.eti.book.validator.exception.ValidatorException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PublishingHouseDefaultService implements PublishingHouseService {

    private final PublishingHouseRepository repository;

    private final PublishingHouseNameValidator nameValidator;

    @Autowired
    public PublishingHouseDefaultService(
            PublishingHouseRepository repository,
            PublishingHouseNameValidator nameValidator) {
        this.repository = repository;
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
    }

    @Override
    public void delete(UUID publishingHouse) {
        repository.findById(publishingHouse).ifPresent(repository::delete);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
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
