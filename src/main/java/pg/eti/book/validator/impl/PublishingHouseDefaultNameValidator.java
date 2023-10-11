package pg.eti.book.validator.impl;

import org.springframework.stereotype.Component;
import pg.eti.book.validator.api.PublishingHouseNameValidator;
import pg.eti.book.validator.exception.ValidatorException;

import java.util.regex.Pattern;

@Component
public class PublishingHouseDefaultNameValidator implements PublishingHouseNameValidator {

	private final String publishingHouseNameRegex = "[A-Z][a-zA-Z ]+";

	@Override
	public void validateName(String publishingHouseName) throws ValidatorException {
		if(publishingHouseName.isEmpty()) {
			throw new ValidatorException("Publishing house name must be specified");
		}

		Pattern pattern = Pattern.compile(publishingHouseNameRegex);
		boolean doesNameMatchRegex = pattern.matcher(publishingHouseName).matches();
		if (!doesNameMatchRegex) {
			throw new ValidatorException("Name must contain only letters and spaces");
		}

	}
}
