package com.seleniumexpress.ibc.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.seleniumexpress.ibc.dto.CreditCard;

public class CreditCardFormatter implements Formatter<CreditCard> {

	@Override
	public String print(CreditCard object, Locale locale) {
		
		return null;
	}

	@Override
	public CreditCard parse(String text, Locale locale) throws ParseException {
		
		//splitting the credit card
		
		String[] digitArray = text.split("-");
		
		//setting credit card value
		
		CreditCard creditCard = new CreditCard();
		
		creditCard.setFirstFourDigits(Integer.valueOf(digitArray[0]));
		creditCard.setSecondFourDigits(Integer.valueOf(digitArray[1]));
		creditCard.setThirdFourDigits(Integer.valueOf(digitArray[2]));
		creditCard.setLastFourDigits(Integer.valueOf(digitArray[3]));
		
		return creditCard;
	}

}
