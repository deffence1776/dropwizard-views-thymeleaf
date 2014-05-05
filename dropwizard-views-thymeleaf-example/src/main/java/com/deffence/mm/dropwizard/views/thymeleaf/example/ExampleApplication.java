package com.deffence.mm.dropwizard.views.thymeleaf.example;


import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import io.dropwizard.views.ViewRenderer;

import com.deffence.mm.dropwizard.views.thymeleaf.example.resources.ExampleResource;
import com.google.common.collect.ImmutableSet;

public class ExampleApplication extends Application<ExampleConfiguration> {

	public static void main(String[] args) throws Exception{
		new ExampleApplication().run(args);
	}
	
	
	@Override
	public void initialize(Bootstrap<ExampleConfiguration> bootstrap) {
		ImmutableSet<ViewRenderer> renderes= ImmutableSet.of((ViewRenderer)new com.deffence.mm.dropwizard.thymeleaf.ThymeleafViewRenderer());
		bootstrap.addBundle(new ViewBundle(renderes));
		
	}

	@Override
	public void run(ExampleConfiguration configuration, Environment environment)
			throws Exception {
		environment.jersey().register(new ExampleResource());
		
	}

}
