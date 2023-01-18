package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {
    @Id @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    private List<Member> members = new ArrayList<>();

    private String name;

    public Team(String name) {
        this.name = name;
    }

    protected Team() {}

    public String getName() {
        return name;
    }

    public List<Member> getMembers() {
        return members;
    }
}
