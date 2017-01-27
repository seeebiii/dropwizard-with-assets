package de.sebastianhesse.examples;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


/**
 * A simple HelloWorld resource.
 */
@Path("/hello")
public class HelloWorldResource {

    private DropwizardConfiguration configuration;


    public HelloWorldResource(DropwizardConfiguration configuration) {
        this.configuration = configuration;
    }


    @GET
    public Response getHelloWorldMessage() {
        return Response.ok("Hello World! " + this.configuration.getMessage()).build();
    }
}
