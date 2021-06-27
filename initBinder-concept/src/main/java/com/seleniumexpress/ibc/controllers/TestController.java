package com.seleniumexpress.ibc.controllers;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seleniumexpress.ibc.dto.BillDTO;
import com.seleniumexpress.ibc.dto.CreditCard;
import com.seleniumexpress.ibc.propertyeditor.CreditCardEditor;
import com.seleniumexpress.ibc.propertyeditor.MyCurrencyEditor;

@Controller
public class TestController {
	
	@RequestMapping("/")
	public String showBillPage(@ModelAttribute("billDTO") BillDTO billDTO) {
		
		CreditCard card = new CreditCard();
		card.setFirstFourDigits(1234);
		card.setSecondFourDigits(2222);
		card.setThirdFourDigits(2245);
		card.setLastFourDigits(6545);
		
		billDTO.setCreditCard(card);
		
		
		return "bill-page";
	}
	
	@RequestMapping("/process-bill")
	public String showResultPage(@Valid @ModelAttribute("billDTO") BillDTO billDTO, BindingResult result) {
		
		if (result.hasErrors()) {
			
			return "bill-page";
		}
		
		return "result-page";
				
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
		// editor for date field
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
		CustomDateEditor customDateEditor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, "date", customDateEditor);
		
		//Register a custom editor for amount field
		
		NumberFormat numberFormat = new DecimalFormat("##,###.00");
		CustomNumberEditor customNumberEditor = new CustomNumberEditor(BigDecimal.class, numberFormat ,true);
		binder.registerCustomEditor(BigDecimal.class, "amount", customNumberEditor);
		
		//Register a custom editor for currency
		
		MyCurrencyEditor myCurrencyEditor = new MyCurrencyEditor();
		binder.registerCustomEditor(Currency.class, "currency" , myCurrencyEditor);
		
		//CreditCardEditor cardEditor = new CreditCardEditor();
		//binder.registerCustomEditor(CreditCard.class, "creditCard" , cardEditor);
		
		
	}
	

}
