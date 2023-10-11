package pg.eti.book.validator.api;

import pg.eti.book.validator.exception.ValidatorException;

public interface PublishingHouseNameValidator {

	void validateName(String publishingHouseName) throws ValidatorException;
}
