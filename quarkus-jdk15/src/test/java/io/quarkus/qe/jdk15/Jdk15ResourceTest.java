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



}