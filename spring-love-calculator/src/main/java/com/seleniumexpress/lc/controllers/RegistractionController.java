package com.seleniumexpress.lc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seleniumexpress.lc.api.CommunicationDTO;
import com.seleniumexpress.lc.api.Phone;
import com.seleniumexpress.lc.api.UserRegistractionDTO;
import com.seleniumexpress.lc.propertyeditor.NamePropertyEditor;
import com.seleniumexpress.lc.validator.EmailValidator;
import com.seleniumexpress.lc.validator.UserNameValidator;

@Controller
public class RegistractionController {

	@Autowired
	private EmailValidator emailValidator;

	@RequestMapping("/register")
	public String showRegistractioPage(@ModelAttribute("userReg") UserRegistractionDTO dto) {

		System.out.println("inside showRegistractionPage method");

		Phone phone = new Phone();
		phone.setCountryCode("92");
		phone.setUserNumber("3320328447");

		CommunicationDTO communicationDTO = new CommunicationDTO();
		communicationDTO.setPhone(phone);

		dto.setCommunicationDTO(communicationDTO);

		return "user-registraction-page";
	}

	@RequestMapping("/registraction-success")
	public String processUserReg(@Valid @ModelAttribute("userReg") UserRegistractionDTO dto, BindingResult result) {

		System.out.println("inside processReg method");
		System.out.println("Name value Enterd by the user :" + "|" + dto.getName() + "|");

		emailValidator.validate(dto, result);

		if (result.hasErrors()) {
			System.out.println("My page has errors");

			List<ObjectError> allErrors = result.getAllErrors();

			for (ObjectError error : allErrors) {
				System.out.println(error);
			}

			return "user-registraction-page";

		}

		return "registraction-success";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {

		System.out.println("inside init binder method....");

		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, "name", editor);

		NamePropertyEditor propertyEditor = new NamePropertyEditor();
		binder.registerCustomEditor(String.class, "name", propertyEditor);

		// binder.setDisallowedFields("name");

		binder.addValidators(new UserNameValidator());
		// binder.addValidators(new EmailValidator());
	}
}
