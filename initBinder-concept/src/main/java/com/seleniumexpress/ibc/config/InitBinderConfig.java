package com.seleniumexpress.ibc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.seleniumexpress.ibc.formatter.CreditCardFormatter;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.seleniumexpress.ibc")
public class InitBinderConfig implements WebMvcConfigurer {
	
	@Bean
	public InternalResourceViewResolver viewResolver() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	/*
	 * @Override public void addFormatters(FormatterRegistry registry) {
	 * 
	 * registry.addFormatter(new CreditCardFormatter()); }
	 */
}
