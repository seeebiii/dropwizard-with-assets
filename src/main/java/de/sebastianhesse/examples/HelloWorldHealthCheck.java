package de.sebastianhesse.examples;

import com.codahale.metrics.health.HealthCheck;


/**
 * A health check that a message is set in the configuration file.
 */
public class HelloWorldHealthCheck extends HealthCheck {

    private DropwizardConfiguration configuration;


    public HelloWorldHealthCheck(DropwizardConfiguration configuration) {
        this.configuration = configuration;
    }


    protected Result check() throws Exception {
        if (this.configuration != null) {
            String message = this.configuration.getMessage();
            if (message != null && !"".equals(message)) {
                return Result.healthy();
            }
        }
        return Result.unhealthy("Message in DropwizardConfiguration is not set.");
    }
}
