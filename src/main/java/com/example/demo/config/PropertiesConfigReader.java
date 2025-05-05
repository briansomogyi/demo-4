package com.example.demo.config;

import lombok.Getter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesConfigReader {

    public static final Properties PROPERTIES;

    static {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            PROPERTIES = new Properties();
            PROPERTIES.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read PROPERTIES config", e);
        }
    }

    public static String get(String key) {
        return PROPERTIES.getProperty(key);
    }
}
