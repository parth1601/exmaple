package org.example.resource;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.example.service.ExampleService;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@QuarkusTest
class ExampleResourceTest {

    @Inject
    ExampleResource exampleResource;

    @InjectMock
    ExampleService exampleService;

    @Test
    void fetchData_runSuccessFully_shouldBeSuccess() {
        doNothing().when(exampleService).fetchDataAndWriteToFile();

        exampleResource.fetchData();

        verify(exampleService, times(1)).fetchDataAndWriteToFile();
    }
}