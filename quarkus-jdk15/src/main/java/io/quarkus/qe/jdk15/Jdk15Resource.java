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
}