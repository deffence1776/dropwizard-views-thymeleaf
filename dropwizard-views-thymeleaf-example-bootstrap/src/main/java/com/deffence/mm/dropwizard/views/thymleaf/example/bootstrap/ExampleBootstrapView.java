package com.deffence.mm.dropwizard.views.thymleaf.example.bootstrap;

import com.deffence.mm.dropwizard.thymeleaf.ThymeleafView;

/**
 * Created by mmatsushita on 2014/05/16.
 */
public class ExampleBootstrapView extends ThymeleafView{
    private String value;

    protected ExampleBootstrapView() {
        super("index.html");
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
