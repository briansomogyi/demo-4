package com.example.demo.client;

import com.example.demo.config.JsonConfigReader;
import io.restassured.RestAssured;

public class ApiClient {

    public static String get(String endpoint, int statusCode) {
        return RestAssured
                .given()
                .baseUri(JsonConfigReader.getCONFIG_JSON().baseUrl)
                .when()
                .log().all()
                .get(endpoint)
                .then()
                .log().all()
                .statusCode(statusCode)
                .extract()
                .response()
                .asString();
    }

    public static String getUsersWithToken(String endpoint, int statusCode, String token) {
        return RestAssured
                .given()
                .baseUri(JsonConfigReader.getCONFIG_JSON().baseUrl)
                .header("x-api-key", token)
                .when()
                .log().all()
                .get(endpoint)
                .then()
                .log().all()
                .statusCode(statusCode)
                .extract()
                .response()
                .asString();
    }
}
