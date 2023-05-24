package org.example.service;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.example.client.Client;
import org.example.data.Writer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.io.IOException;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@QuarkusTest
class ExampleServiceTest {

    @Inject
    ExampleService exampleService;

    @InjectMock
    Writer writer;

    @InjectMock
    Client client;

    private static String response;

    @BeforeAll
    static void setUp() {
        response = "{\"id\": %1$s, \"message\": \"lorem ipsum %1$s\"}".formatted(Math.random());
    }

    @Test
    void fetchDataAndWriteToFile_whenRunSuccessfully_shouldBeSuccess() throws IOException {
        doReturn(response).doReturn(response).when(client).demoAPICall();
        doReturn(false).doReturn(true).when(writer).appendJson(response);
        doNothing().when(writer).writeToFile();

        exampleService.fetchDataAndWriteToFile();

        verify(client, times(2)).demoAPICall();
    }

    @Test
    void fetchDataAndWriteToFile_whenIOExceptionOccurs_shouldBeFail() throws IOException {
        doReturn(response).when(client).demoAPICall();
        doThrow(IOException.class).when(writer).appendJson(response);

        exampleService.fetchDataAndWriteToFile();
    }
}