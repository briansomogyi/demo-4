package com.example.demo;

import com.example.demo.client.getUsers.GetUser;
import com.example.demo.config.JsonConfigReader;
import com.example.demo.config.PropertiesConfigReader;
import com.example.demo.config.YamlConfigReader;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.demo.client.getUsers.GetUser.*;

@SpringBootTest
class DemoApplicationTests {

    public static final String AUTH_TOKEN = "reqres-free-v1";

    @Test
    void contextLoads() {
        System.out.println(JsonConfigReader.getCONFIG_JSON().baseUrl);
        System.out.println(YamlConfigReader.getCONFIG_YAML().browser);
        System.out.println(PropertiesConfigReader.get("timeout"));
    }

    @Test
    void e2eTest() {
        System.out.println(getUsers("/api/users?page=2", 200));
        System.out.println(getUser("/api/user/7", 200, AUTH_TOKEN));
        System.out.println(GetUser.userNotFound("/api/user/23", 404, AUTH_TOKEN));
    }

    @Test
    void getListOfUsers() {
        System.out.println(getUsers("/api/users?page=2", 200));
    }

    @Test
    void getSingleUser() {
        System.out.println(getUser("/api/user/7", 200, AUTH_TOKEN));
    }

    @Test
    void userNotFound() {
        System.out.println(GetUser.userNotFound("/api/user/23", 404, AUTH_TOKEN));
    }
}
