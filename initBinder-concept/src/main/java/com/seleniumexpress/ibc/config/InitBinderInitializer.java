package com.seleniumexpress.ibc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class InitBinderInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class arr[] = {InitBinderConfig.class};
		return arr;
	}

	@Override
	protected String[] getServletMappings() {
		String arr[] = {"/"};
		return arr;
	}

}
