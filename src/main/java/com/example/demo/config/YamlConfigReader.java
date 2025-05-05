package com.example.demo.config;

import com.example.demo.model.ConfigYaml;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.Getter;

import java.io.File;
import java.io.IOException;

public class YamlConfigReader {

    @Getter
    public static final ConfigYaml CONFIG_YAML;

    static {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            CONFIG_YAML = mapper.readValue(new File("src/main/resources/config.yaml"), ConfigYaml.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read YAML config", e);
        }
    }
}
