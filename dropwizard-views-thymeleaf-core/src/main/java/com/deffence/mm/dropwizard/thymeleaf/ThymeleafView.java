package com.deffence.mm.dropwizard.thymeleaf;

import java.nio.charset.Charset;

import io.dropwizard.views.View;

/**
 * 
 * @author mmatsushita
 *
 */
public abstract class ThymeleafView extends View {

	private String simpleTemplateName;
	
	protected ThymeleafView(String templateName) {
		super(templateName);
	}

	public ThymeleafView(String templateName, Charset charset) {
		super(templateName, charset);
	}

	@Override
	public String getTemplateName() {
		
		if(null == simpleTemplateName){
			simpleTemplateName = convertToSimpleTemplateName(super.getTemplateName());
		}
		return simpleTemplateName;
		
	}

	private String convertToSimpleTemplateName(String templateName) {
		String[] names = templateName.split("/");
		
		return names[names.length-1];
	}
	
	
	
	

}
