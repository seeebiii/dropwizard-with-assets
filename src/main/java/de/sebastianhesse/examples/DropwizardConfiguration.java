package de.sebastianhesse.examples;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;


/**
 * Configuration class for the Dropwizard application.
 */
public class DropwizardConfiguration extends Configuration {

    private String message;


    @JsonProperty
    public String getMessage() {
        return message;
    }


    @JsonProperty
    public void setMessage(String message) {
        this.message = message;
    }
}
