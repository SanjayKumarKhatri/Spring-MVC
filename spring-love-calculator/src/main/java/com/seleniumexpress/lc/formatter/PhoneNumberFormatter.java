package com.seleniumexpress.lc.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.seleniumexpress.lc.api.Phone;

public class PhoneNumberFormatter implements Formatter<Phone> {

	@Override
	public String print(Phone phone, Locale locale) {

		System.out.println("inside the print method of the PhoneNumberFormatter");

		return phone.getCountryCode() + " - " + phone.getUserNumber();
	}

	@Override
	public Phone parse(String completePhoneNumber, Locale locale) throws ParseException {

		System.out.println("inside the parse method of the phone number");

		Phone phone = new Phone();

		// split the string received from the user
		String[] phoneNumberArray = completePhoneNumber.split("-");

		// wether the number conists of -
		int index = completePhoneNumber.indexOf("-");
		if (index == -1 || completePhoneNumber.startsWith("-")) {

			// if the '-' is not found, than the 92 as the default country code

			phone.setCountryCode("92");

			if (completePhoneNumber.startsWith("-")) {

				phone.setUserNumber(phoneNumberArray[1]);

			} else {

				phone.setUserNumber(phoneNumberArray[0]);
			}

		} else {

			// Extract the country code and set it to the phone class countryCodeProperty
			phone.setCountryCode(phoneNumberArray[0]);
			phone.setUserNumber(phoneNumberArray[1]);
		}
		return phone;
	}

}
