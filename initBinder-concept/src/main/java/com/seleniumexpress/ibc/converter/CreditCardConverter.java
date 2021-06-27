package com.seleniumexpress.ibc.converter;

import org.springframework.core.convert.converter.Converter;

import com.seleniumexpress.ibc.dto.CreditCard;

public class CreditCardConverter implements Converter<String, CreditCard> {

	@Override
	public CreditCard convert(String source) {

		// splitting the credit card

		String[] digitArray = source.split("-");

		// setting credit card value

		CreditCard creditCard = new CreditCard();

		creditCard.setFirstFourDigits(Integer.valueOf(digitArray[0]));
		creditCard.setSecondFourDigits(Integer.valueOf(digitArray[1]));
		creditCard.setThirdFourDigits(Integer.valueOf(digitArray[2]));
		creditCard.setLastFourDigits(Integer.valueOf(digitArray[3]));
		
		return creditCard;
	}

}
