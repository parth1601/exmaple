package org.example.service;

import org.example.client.Client;
import org.example.data.Writer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;

@ApplicationScoped
public class ExampleService {

    @Inject
    Writer writer;

    @Inject
    Client client;

    public void fetchDataAndWriteToFile() {
        try {
            while (true) {
                String response = client.demoAPICall();
                if (response == null || writer.appendJson(response)) {
                    break;
                }
            }

            // If the limit is not reached then add all the data to file
            writer.writeToFile();

            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            System.err.println("Error writing data to file: " + e.getMessage());
        }
    }
}
