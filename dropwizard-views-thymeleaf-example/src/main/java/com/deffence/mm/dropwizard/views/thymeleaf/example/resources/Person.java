package com.deffence.mm.dropwizard.views.thymeleaf.example.resources;

public class Person {

	private String name;
	private int age;
	
	
	protected Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
