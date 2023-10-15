package pg.eti.publishinghouse.validator.api;

import pg.eti.publishinghouse.validator.exception.ValidatorException;

public interface PublishingHouseNameValidator {

	void validateName(String publishingHouseName) throws ValidatorException;
}
