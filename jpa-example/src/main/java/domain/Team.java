package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Team {
    @Id @GeneratedValue
    private Long id;

    private String name;

    public Team(String name) {
        this.name = name;
    }

    protected Team() {}

    public String getName() {
        return name;
    }
}
