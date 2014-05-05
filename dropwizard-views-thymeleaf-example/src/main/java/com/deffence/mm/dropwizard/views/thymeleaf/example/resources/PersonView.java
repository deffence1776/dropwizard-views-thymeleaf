package com.deffence.mm.dropwizard.views.thymeleaf.example.resources;

import java.util.List;

import com.deffence.mm.dropwizard.thymeleaf.ThymeleafView;

public class PersonView extends ThymeleafView {

	private Person person;
	private List<Person> persons;
	
	
	protected PersonView(String templateName,Person p ,List<Person> pList) {
		super(templateName);
		person = p;
		persons =pList;
	}
	
	
	
	public Person getPerson() {
		return person;
	}
	public List<Person> getPersons() {
		return persons;
	}
	
}
