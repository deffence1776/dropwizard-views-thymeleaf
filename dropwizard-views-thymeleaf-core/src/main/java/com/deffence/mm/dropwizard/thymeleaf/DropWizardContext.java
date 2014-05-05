package com.deffence.mm.dropwizard.thymeleaf;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import io.dropwizard.views.View;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;

import org.thymeleaf.context.AbstractContext;
import org.thymeleaf.context.IContextExecutionInfo;
import org.thymeleaf.context.WebContextExecutionInfo;

public class DropWizardContext extends AbstractContext {

	public DropWizardContext() {
		super();

	}

	public DropWizardContext(View view) {
		super();
		checkNotNull(view, "view can not be null.");

		try {
			initVariableFromViewProperties(view);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | IntrospectionException e) {
			checkArgument(false,
					"failure to create DropwizardContext.view setting is wrong.");
		}

	}

	private void initVariableFromViewProperties(View view)
			throws IntrospectionException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {

		PropertyDescriptor[] propertyDescs = Introspector.getBeanInfo(
				view.getClass(), View.class).getPropertyDescriptors();

		for (PropertyDescriptor desc : propertyDescs) {

			String propName = desc.getDisplayName();
			Method method = desc.getReadMethod();
			
			setVariable(propName, method.invoke(view, new Object[0]));

		}

	}

	@Override
	protected IContextExecutionInfo buildContextExecutionInfo(
			final String templateName) {
		final Calendar now = Calendar.getInstance();
		return new WebContextExecutionInfo(templateName, now);
	}

}
