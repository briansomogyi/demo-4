package com.example.demo.config;

import com.example.demo.model.ConfigJson;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

import java.io.File;
import java.io.IOException;

public class JsonConfigReader {

    @Getter
    public static final ConfigJson CONFIG_JSON;

    static {
        ObjectMapper mapper = new ObjectMapper();
        try {
            CONFIG_JSON = mapper.readValue(new File("src/main/resources/config.json"), ConfigJson.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON config", e);
        }
    }
}
