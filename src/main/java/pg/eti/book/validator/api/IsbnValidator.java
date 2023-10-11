package pg.eti.book.validator.api;

import pg.eti.book.validator.exception.ValidatorException;

public interface IsbnValidator {

	void validateIsbn(String isbn) throws ValidatorException;
}
