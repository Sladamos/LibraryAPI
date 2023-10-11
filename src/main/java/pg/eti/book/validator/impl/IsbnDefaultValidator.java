package pg.eti.book.validator.impl;

import org.springframework.stereotype.Component;
import pg.eti.book.validator.api.IsbnValidator;
import pg.eti.book.validator.exception.ValidatorException;

import java.util.regex.Pattern;

@Component
public class IsbnDefaultValidator implements IsbnValidator {

	private final int isbnLength = 13;
	private final String isbnRegex = "[0-9]+";

	@Override
	public void validateIsbn(String isbn) throws ValidatorException {
		if (isbn.isEmpty()) {
			throw new ValidatorException("ISBN can't be empty");
		}

		if (isbn.length() != isbnLength) {
			throw new ValidatorException("ISBN length is specified to 13");
		}

		Pattern pattern = Pattern.compile(isbnRegex);
		boolean doesContainsDigitsOnly = pattern.matcher(isbn).matches();
		if (!doesContainsDigitsOnly) {
			throw new ValidatorException("ISBN must have digits only");
		}
	}
}
