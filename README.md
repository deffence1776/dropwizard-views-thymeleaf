dropwizard-views-thymeleaf
==========================

Dropwizard のテンプレートエンジンとして、Thymeleaf Viewsを利用する

#What is Thymeleaf
http://www.thymeleaf.org/

##Getting Started
Dropwizard App:

```java
	public class ExampleApplication extends Application<ExampleConfiguration> {

	 public static void main(String[] args) throws Exception{
	 	new ExampleApplication().run(args);
	 }


	@Override
	public void initialize(Bootstrap<ExampleConfiguration> bootstrap) {
		//set ThymeleafView Render
		ImmutableSet<ViewRenderer> renderes= ImmutableSet.of((ViewRenderer)new ThymeleafViewRenderer());
		bootstrap.addBundle(new ViewBundle(renderes));

	}

	@Override
	public void run(ExampleConfiguration configuration, Environment environment)
			throws Exception {
		environment.jersey().register(new ExampleResource());

	}  
}

```
you can change the template mode,cacheTTLs,template suffix and template prefix.

#View 
using ThymeleafView:

```java
	public class PersonView extends ThymeleafView {
	
	private Person person;//model used in template
	private List<Person> persons;//model used in template


	protected PersonView(String templateName,Person p ,List<Person> pList) {
		super(templateName);
		person = p;
		persons =pList;
	}
	
	//add getter for use
	public Person getPerson() {
		return person;
	}
	
	//add getter for use
	public List<Person> getPersons() {
		return persons;
	}

  }
```

resource example:
```java
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

```
#template
default location:
classpath:/templates/something.html<br/>
    [/template/] is libraly default prefix. you can change default prefix by  ThymeleafViewRenderer's constructor. 

template example:

```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title th:text="#{title}">Welcome Page</title>
</head>
<body>
		<p>Welcome</p>
		<span th:text="#{name}" value="名前用" />
		<input type="text" th:value="${person.name}" value="ユーザさん" />
		<span th:text="#{age}" value="年齢用" />
		<input type="text" th:value="${person.age}" value="?才" />
		<table border="1">
			<tr>
				<th><span th:text="#{name}" value="名前用" /></th>
				<th><span th:text="#{age}" value="年齢用" /></th>
			</tr>
			<tr th:each="p : ${persons}">
				<td th:text="${p.name}"></td>
				<td th:text="${p.age}"></td>
			</tr>
		</table>
	<div th:include="/footer.html::copy"></div>
</body>
</html>

```
#Assets
use static files 
https://github.com/deffence1776/dropwizard-views-thymeleaf/tree/master/dropwizard-views-thymeleaf-example


```java
public class ExampleBootstrapAppication extends Application<ExampleBootstrapConfigration>{

    public static void main(String[] args) throws Exception {
        new ExampleBootstrapAppication().run(args);
    }

    @Override
    public void initialize(Bootstrap<ExampleBootstrapConfigration> bootstrap) {
        ImmutableSet<ViewRenderer> renderes= ImmutableSet.of((ViewRenderer)new ThymeleafViewRenderer());
        bootstrap.addBundle(new ViewBundle(renderes));

        //configure assets。
       bootstrap.addBundle(new AssetsBundle("/templates","/"));
    }

    @Override
    public void run(ExampleBootstrapConfigration configuration, Environment environment)
            throws Exception {

        environment.jersey().register(new ExampleBootstrapResource());

    }
}

```
classpath:templates---index.html(templateHTMLfile)
		    |-css
		    |-fonts
		    |-js
		    
