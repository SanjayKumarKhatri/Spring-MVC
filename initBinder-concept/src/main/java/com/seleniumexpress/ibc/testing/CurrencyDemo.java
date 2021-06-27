package com.seleniumexpress.ibc.testing;

import java.util.Currency;

public class CurrencyDemo {
	
	public static void main(String[] args) {
	
		Currency currency = Currency.getInstance("USD");
		System.out.println(currency.getDisplayName());
	}

}
