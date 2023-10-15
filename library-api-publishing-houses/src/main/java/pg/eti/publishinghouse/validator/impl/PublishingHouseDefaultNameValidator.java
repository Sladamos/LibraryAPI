package pg.eti.publishinghouse.validator.impl;

import org.springframework.stereotype.Component;
import pg.eti.publishinghouse.validator.api.PublishingHouseNameValidator;
import pg.eti.publishinghouse.validator.exception.ValidatorException;

import java.util.regex.Pattern;

@Component
public class PublishingHouseDefaultNameValidator implements PublishingHouseNameValidator {

	private final String publishingHouseNameRegex = "\\p{IsAlphabetic}[\\p{IsAlphabetic}\s]+";

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
