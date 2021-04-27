package org.acme.aloha.code.it;

import static io.quarkus.devtools.codestarts.quarkus.QuarkusCodestartCatalog.Language.JAVA;
import static io.quarkus.devtools.codestarts.quarkus.QuarkusCodestartCatalog.Language.KOTLIN;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import io.quarkus.devtools.testing.codestarts.QuarkusCodestartTest;
import io.quarkus.maven.ArtifactCoords;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.util.Collections;

public class AlohaCodeCodestartIT {

    @RegisterExtension
    public static QuarkusCodestartTest codestartTest = QuarkusCodestartTest.builder()
            .codestarts("aloha-code")
            .artifacts(Collections.singleton("org.acme:aloha-code:codestarts:jar:1.0.0-SNAPSHOT"))
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
