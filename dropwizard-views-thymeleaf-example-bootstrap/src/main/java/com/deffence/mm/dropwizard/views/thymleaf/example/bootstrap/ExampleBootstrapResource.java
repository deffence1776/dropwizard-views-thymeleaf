package com.deffence.mm.dropwizard.views.thymleaf.example.bootstrap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by mmatsushita on 2014/05/16.
 */
@Path("/")
public class ExampleBootstrapResource {

    @GET
    public ExampleBootstrapView index(){
        return new  ExampleBootstrapView();
    }

}
