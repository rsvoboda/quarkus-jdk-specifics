package io.quarkus.qe.jdk15;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class Jdk15Resource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        String foo = "abcx";
        switch (foo) {
            case "foo" -> { return "Back to work."; }
            case "bar" -> { return "Wait for the end of week..."; }
            case "baz" -> { return "Plan for the weekend?"; }
            case "abc" -> { return "Enjoy the holiday!"; }
            default -> { return "hello"; }
        }
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/blocks")
    public String helloBlocks() {
        return """
             function hello() {
                 print('"Hello, world!"');
             }

             hello();
             """;
    }
}