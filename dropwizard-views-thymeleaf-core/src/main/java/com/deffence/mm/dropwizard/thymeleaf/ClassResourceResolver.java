package com.deffence.mm.dropwizard.thymeleaf;

import java.io.InputStream;

import org.thymeleaf.TemplateProcessingParameters;
import org.thymeleaf.resourceresolver.IResourceResolver;

import com.google.common.base.Preconditions;

public class ClassResourceResolver implements IResourceResolver {

	@Override
	public String getName() {
		return "ClassResourceResolver";
	}

	@Override
	public InputStream getResourceAsStream(
			TemplateProcessingParameters templateProcessingParameters,
			String resourceName) {
		return this.getClass().getResourceAsStream(resourceName);
	}

}
