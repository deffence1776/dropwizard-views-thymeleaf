package com.deffence.mm.dropwizard.views.thymeleaf.example.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.google.common.collect.Lists;

@Path("/")
public class ExampleResource {

	@GET
	public PersonView getPersons(){
		
		List<Person> pList = Lists.newArrayList();
		pList.add(new Person("list1",10));
		pList.add(new Person("list2",10));
		
		
		return new PersonView("person.html" ,new Person("name",10), pList);
	}
	
}
