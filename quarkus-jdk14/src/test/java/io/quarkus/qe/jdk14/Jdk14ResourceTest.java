package io.quarkus.qe.jdk14;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class Jdk14ResourceTest {

    @Test
    public void testSwitchExpressions() {
        checkPath("/hello/asd", "hello asd");
        checkPath("/hello/foo", "Back to work.");
        checkPath("/hello/bar", "Wait for the end of week...");
        checkPath("/hello/baz", "Plan for the weekend?");
        checkPath("/hello/abc", "Enjoy the holiday!");
    }
    private void checkPath(String path, String expectedResponse) {
        given()
                .when().get(path)
                .then()
                .statusCode(200)
                .body(is(expectedResponse));
    }

    @Test
    public void testHelpfulNullPointerExceptions() {
        given()
                .when().get("/hello/npe")
                .then()
                .statusCode(200)
                .body(is("Cannot invoke \"String.length()\" because \"holder.foo\" is null"));
    }

}