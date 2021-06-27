package com.seleniumexpress.lc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.seleniumexpress.lc.api.UserRegistractionDTO;

public class UserNameValidator implements Validator {

	//check if the UserNameValidator supports a given object
	
	@Override
	public boolean supports(Class<?> clazz) {
		
		return UserRegistractionDTO.class.equals(clazz);
	}

	//we need to write to our custom validation logic
	
	@Override
	public void validate(Object object, Errors errors) {
		
		//to check if the field is correct
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "userName.empty" , "User name can not be null");
		
		String username = ((UserRegistractionDTO)object).getUsername();
		
		if(!username.contains("_")) {
			errors.rejectValue("username", "username.invalidString", "String must contain a  '_' ");
			
		}

		
	}

}
