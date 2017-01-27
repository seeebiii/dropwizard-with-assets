package de.sebastianhesse.examples;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


/**
 * Starter class for the application.
 */
public class DropwizardApplication extends Application<DropwizardConfiguration> {

    public DropwizardApplication() {
    }


    public static void main(String[] args) throws Exception {
        new DropwizardApplication().run(args);
    }


    @Override
    public String getName() {
        return "dropwizard-with-assets";
    }


    @Override
    public void initialize(Bootstrap<DropwizardConfiguration> bootstrap) {
        // in order to serve HTML files and alike, the root path of the server serves our assets
        bootstrap.addBundle(new AssetsBundle("/assets/", "/", "index.html"));
        bootstrap.addBundle(new AssetsBundle("/assets/css", "/css", null, "css"));
        bootstrap.addBundle(new AssetsBundle("/assets/js", "/js", null, "js"));
        bootstrap.addBundle(new AssetsBundle("/assets/fonts", "/fonts", null, "fonts"));
    }


    @Override
    public void run(DropwizardConfiguration configuration, Environment environment) {
        // set url pattern for resources, i.e. they can be accessed by /api/{resourcePath}
        environment.jersey().setUrlPattern("/api/*");
        environment.jersey().register(new HelloWorldResource(configuration));

        // recommended: add a health check
        environment.healthChecks().register("HelloWorldHealthCheck", new HelloWorldHealthCheck(configuration));
    }

}
