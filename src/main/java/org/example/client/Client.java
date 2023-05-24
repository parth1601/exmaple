package org.example.client;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Client {

    public String demoAPICall() {
        return "{\"id\": %1$s, \"message\": \"lorem ipsum %1$s\"}".formatted(Math.random());
    }
}
