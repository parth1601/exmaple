package org.example.data;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.config.Config;
import org.example.constant.Constant;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@NoArgsConstructor
@AllArgsConstructor
public class Writer {

    @Inject
    Config config;

    private final List<String> jsonBuffer = new ArrayList<>();
    private int currentBufferSize = 0;

    public boolean appendJson(String json) throws IOException {
        jsonBuffer.add(json);
        currentBufferSize += json.length();

        /*
        Auto trigger when reached to limit
        */
        if (currentBufferSize >= (config.data().bufferSize() * Constant.MB)) {
            writeToFile();
            return true;
        }
        return false;
    }

    public void writeToFile() throws IOException {
        try (
                BufferedWriter writer = new BufferedWriter(
                        new FileWriter(config.data().outputFilePath(), true)
                )
        ) {
            for (String json : jsonBuffer) {
                writer.write(json);
                writer.newLine();
            }
        }

        jsonBuffer.clear();
        currentBufferSize = 0;
    }

}


