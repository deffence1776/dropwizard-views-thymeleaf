package com.deffence.mm.dropwizard.views.thymleaf.example.bootstrap;

import com.deffence.mm.dropwizard.thymeleaf.ThymeleafViewRenderer;
import com.google.common.collect.ImmutableSet;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import io.dropwizard.views.ViewRenderer;

/**
 * Created by mmatsushita on 2014/05/16.
 */
public class ExampleBootstrapAppication extends Application<ExampleBootstrapConfigration>{

    public static void main(String[] args) throws Exception {
        new ExampleBootstrapAppication().run(args);
    }

    @Override
    public void initialize(Bootstrap<ExampleBootstrapConfigration> bootstrap) {
        ImmutableSet<ViewRenderer> renderes= ImmutableSet.of((ViewRenderer)new ThymeleafViewRenderer());
        bootstrap.addBundle(new ViewBundle(renderes));

        //静的ファイルの設定。ThymeleafViewRendererのtemplateファイル配置場所を設定
       bootstrap.addBundle(new AssetsBundle("/templates","/"));
    }

    @Override
    public void run(ExampleBootstrapConfigration configuration, Environment environment)
            throws Exception {

        environment.jersey().register(new ExampleBootstrapResource());

    }
}
