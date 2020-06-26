package io.quarkus.qe.jdk15;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Jdk15Entity {
    @Id
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
