package com.deffence.mm.dropwizard.views.thymeleaf.example;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;

public class ExampleConfiguration extends Configuration {

	@JsonProperty
	private String appName;

	
	
	public void setAppName(String appName) {
		this.appName = appName;
	}



	public String getAppName() {
		return appName;
	}
	
	
}
