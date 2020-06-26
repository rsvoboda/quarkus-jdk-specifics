package io.quarkus.qe.jdk15;

record Author (int id, String name, String topic) {
    static int followers;

    public static String followerCount() {
        return followers + " followers";
    }

    public String description(){
        return "Author "+ name + " writes on "+ topic;
    }

    public Author {
        if (id < 0) {
            throw new IllegalArgumentException( "id must be greater than 0.");
        }
    }
}
