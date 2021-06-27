package com.seleniumexpress.ibc.propertyeditor;

import java.beans.PropertyEditorSupport;

import com.seleniumexpress.ibc.dto.CreditCard;

public class CreditCardEditor extends PropertyEditorSupport {

	@Override
	public String getAsText() {

		CreditCard creditCard = (CreditCard) getValue();

		return "sample : " + creditCard;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		// splitting the credit card

		String[] digitArray = text.split("-");

		// setting credit card value

		CreditCard creditCard = new CreditCard();

		creditCard.setFirstFourDigits(Integer.valueOf(digitArray[0]));
		creditCard.setSecondFourDigits(Integer.valueOf(digitArray[1]));
		creditCard.setThirdFourDigits(Integer.valueOf(digitArray[2]));
		creditCard.setLastFourDigits(Integer.valueOf(digitArray[3]));

		setValue(creditCard);
	}

}
