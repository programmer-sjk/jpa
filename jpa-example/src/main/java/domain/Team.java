package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {
    @Id @GeneratedValue
    private Long id;

    private String name;
    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();


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

    public void addMember(Member member) {
        if (!this.members.contains(member)) {
            this.members.add(member);
        }
    }
}
