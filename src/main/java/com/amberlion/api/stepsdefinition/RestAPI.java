package com.amberlion.api.stepsdefinition;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestAPI {
    @Given("A GET request is sent")
    public void a_get_request_is_sent() {
        System.out.println("Hello");

        Response response = given()
                .when()
                .get("https://jsonplaceholder.typicode.com/users");

        System.out.println(response);

    }
}
