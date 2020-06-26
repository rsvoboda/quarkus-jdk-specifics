package io.quarkus.qe.jdk15;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class Jdk15Resource {

    // JEP 378: 	Text Blocks
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

    // JEP 384: 	Records (Second Preview)
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/record")
    public FooRecord helloFooRecord() {
        return new FooRecord("hello");
    }

    // JEP 375: 	Pattern Matching for instanceof (Second Preview)
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/pm")
    public String helloPatternMatching() {
        Object o = "my custom string";

        if (!(o instanceof String s && s.length() > 3)) {
            return "N/A";
        }
        return "length:" + s.length();  // s is in scope here
    }

}