package com.example.demo;

import com.example.demo.config.JsonConfigReader;
import com.example.demo.config.PropertiesConfigReader;
import com.example.demo.config.YamlConfigReader;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(JsonConfigReader.getCONFIG_JSON().baseUrl);
        System.out.println(YamlConfigReader.getCONFIG_YAML().browser);
        System.out.println(PropertiesConfigReader.get("timeout"));
    }

}
