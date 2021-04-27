package org.acme.aloha.code.it;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

public class AlohaCodeCodestartIT {

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/aloha-code")
                .then()
                .statusCode(200)
                .body(is("Hello aloha-code"));
    }
}
