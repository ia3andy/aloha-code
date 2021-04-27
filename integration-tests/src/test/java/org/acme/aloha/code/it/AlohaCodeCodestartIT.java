package org.acme.aloha.code.it;

import static io.quarkus.devtools.codestarts.quarkus.QuarkusCodestartCatalog.Language.JAVA;
import static io.quarkus.devtools.codestarts.quarkus.QuarkusCodestartCatalog.Language.KOTLIN;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import io.quarkus.devtools.testing.codestarts.QuarkusCodestartTest;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.extension.RegisterExtension;

public class AlohaCodeCodestartIT {

    @RegisterExtension
    public static QuarkusCodestartTest codestartTest = QuarkusCodestartTest.builder()
            .codestarts("aloha-code")
            .languages(JAVA, KOTLIN)
            .build();


    @Test
    void testContent() throws Throwable {
        codestartTest.checkGeneratedSource("org.acme.MyHelloExample");
    }

    @Test
    @EnabledIfSystemProperty(named = "build-projects", matches = "true")
    void buildAllProjectsForLocalUse() throws Throwable {
        codestartTest.buildAllProjects();
    }
}
