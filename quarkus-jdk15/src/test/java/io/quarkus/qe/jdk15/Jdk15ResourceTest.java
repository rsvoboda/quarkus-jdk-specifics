package io.quarkus.qe.jdk15;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class Jdk15ResourceTest {

    @Test
    public void testTextBlocks() {
        given()
          .when().get("/hello/blocks")
          .then()
             .statusCode(200)
             .body(is("""
                             function hello() {
                                 print('"Hello, world!"');
                             }
                             hello();
                             """));
    }

    @Test
    public void testFooRecord() {
        given()
                .when().get("/hello/record")
                .then()
                .statusCode(200)
                .body(is("FooRecord[name=hello]"));
    }
    @Test
    public void testAuthorRecord() {
        given()
                .when().get("/hello/author")
                .then()
                .statusCode(200)
                .body(is("Author[id=15, name=Rostislav, topic=Java], isRecord: true, Author Rostislav writes on Java, 5 followers"));
    }

    @Test
    public void testPatternMatching() {
        given()
                .when().get("/hello/pm")
                .then()
                .statusCode(200)
                .body(is("length:16"));
    }
}