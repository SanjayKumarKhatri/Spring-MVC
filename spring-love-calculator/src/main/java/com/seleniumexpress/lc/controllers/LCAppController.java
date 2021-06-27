package com.seleniumexpress.lc.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.seleniumexpress.lc.api.UserInfoDTO;

@Controller
@SessionAttributes("userInfo")
public class LCAppController {
	
	@RequestMapping("/")
	public String showHomePage(Model model) {
		
		model.addAttribute("userInfo", new UserInfoDTO());
			
		return "home-page";
	}
	
	@RequestMapping("/process-homepage")
	public String showResultPage(@Valid @ModelAttribute("userInfo") UserInfoDTO userInfoDTO, BindingResult result) {
		
		System.out.println(userInfoDTO.isTermAndCondition());
		
		if (result.hasErrors()) {	
		List<ObjectError> allEerror = result.getAllErrors();
		for(ObjectError temp : allEerror) {
			System.out.println(temp);
			
		}
			
			return "home-page";
		}
		
		
		return "result-page";
	}
}
