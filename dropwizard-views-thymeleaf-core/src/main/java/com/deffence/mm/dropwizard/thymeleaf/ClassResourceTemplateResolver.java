package com.deffence.mm.dropwizard.thymeleaf;

import org.thymeleaf.exceptions.ConfigurationException;
import org.thymeleaf.resourceresolver.IResourceResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

public class ClassResourceTemplateResolver extends TemplateResolver {
	
	public ClassResourceTemplateResolver() {
		super.setResourceResolver(new ClassResourceResolver());
	}


	@Override
	public void setResourceResolver(IResourceResolver resourceResolver) {
		 throw new ConfigurationException(
	                "Cannot set a resource resolver on " + this.getClass().getName() + ". If " +
	                "you want to set your own resource resolver, use " + TemplateResolver.class.getName() + 
	                "instead");
	}

	
}
