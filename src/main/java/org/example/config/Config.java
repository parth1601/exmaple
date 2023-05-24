package org.example.config;

import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "config")
public interface Config {

    Data data();

    interface Data {
        int bufferSize();
        String outputFilePath();
    }

}
