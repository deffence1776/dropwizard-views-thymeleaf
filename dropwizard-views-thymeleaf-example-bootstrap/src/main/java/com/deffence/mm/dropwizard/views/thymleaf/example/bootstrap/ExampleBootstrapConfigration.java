package com.deffence.mm.dropwizard.views.thymleaf.example.bootstrap;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

/**
 * Created by mmatsushita on 2014/05/16.
 */
public class ExampleBootstrapConfigration extends Configuration {

    @JsonProperty
    private String appName;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}
