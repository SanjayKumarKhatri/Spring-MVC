package com.seleniumexpress.lc.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.seleniumexpress.lc.api.UserRegistractionDTO;

@Component
public class EmailValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {

		return UserRegistractionDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "communicationDTO.email", "email.empty",
				"Email can't be blank");

		// weather the email is ending with seleniumexpress.com

		String email = ((UserRegistractionDTO) target).getCommunicationDTO().getEmail();

		if (!email.endsWith("seleniumexpress.com")) {
			errors.rejectValue("communicationDTO.email", "email.invalidDomain",
					"Email should be ending with seleniumexpress.com");
		}

	}

}
