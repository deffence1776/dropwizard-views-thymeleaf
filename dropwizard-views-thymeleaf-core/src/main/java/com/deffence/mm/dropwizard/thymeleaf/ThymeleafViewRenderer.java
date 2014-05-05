package com.deffence.mm.dropwizard.thymeleaf;

import io.dropwizard.views.View;
import io.dropwizard.views.ViewRenderer;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Locale;

import javax.ws.rs.WebApplicationException;

import org.thymeleaf.TemplateEngine;

public class ThymeleafViewRenderer implements ViewRenderer {

		public static final  String DEFAULT_TEMPLATE_MODE ="XHTML";
		public static final  String DEFAULT_SUFFIX =".html";
		public static final  String DEFAULT_PREFIX ="/templates/";
		public static final  long DEFAULT_CACHETTLMS =3600000L;
		
		private String templateMode;
		private String suffix;
		private String prefix;
		private long cacheTTLMs;
		
	
	

	public ThymeleafViewRenderer() {
			this(DEFAULT_TEMPLATE_MODE,DEFAULT_PREFIX,DEFAULT_SUFFIX,DEFAULT_CACHETTLMS);
		}

	public ThymeleafViewRenderer(String templateMode,String prefix, String suffix,
				long cacheTTLMs) {
			super();
			this.templateMode = templateMode;
			this.prefix = prefix;
			this.suffix = suffix;
			this.cacheTTLMs = cacheTTLMs;
		}

	@Override
	public boolean isRenderable(View view) {
		
		return view.getTemplateName().endsWith(suffix);
	}

	@Override
	public void render(View view, Locale locale, OutputStream output)
			throws IOException, WebApplicationException {
		ClassResourceTemplateResolver templateResolver = new ClassResourceTemplateResolver();
		templateResolver.setTemplateMode(templateMode);
        templateResolver.setCacheTTLMs(cacheTTLMs);
        templateResolver.setPrefix(prefix);
		TemplateEngine engine = new TemplateEngine();
        engine.setTemplateResolver(templateResolver);
        
        DropWizardContext context = new DropWizardContext(view);
        
        OutputStreamWriter writer = new OutputStreamWriter(output);
        engine.process(view.getTemplateName(),context,writer);
        writer.flush();
		
	}

}
