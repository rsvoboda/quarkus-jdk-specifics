package io.quarkus.qe.jdk14;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class Jdk14Resource {

    // JEP 361: 	Switch Expressions (Standard)
    @GET
    @Path("/{param}")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@PathParam("param") String param) {
        switch (param) {
            case "foo" -> { return "Back to work."; }
            case "bar" -> { return "Wait for the end of week..."; }
            case "baz" -> { return "Plan for the weekend?"; }
            case "abc" -> { return "Enjoy the holiday!"; }
            default -> { return "hello " + param; }
        }
    }

    // JEP 358: 	Helpful NullPointerExceptions
    private class Holder {
        String foo;
        String bar;
    }
    @GET
    @Path("/npe")
    @Produces(MediaType.TEXT_PLAIN)
    public String helpfulNPE() {
        Holder holder = new Holder();
        try {
            return "length: " + holder.foo.length();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}