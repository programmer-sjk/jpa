package domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Member {
    @Id @GeneratedValue
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToOne
    @JoinColumn(name = "locker_id")
    private Locker locker;

    @OneToMany(mappedBy = "member")
    private List<Orders> memberProducts;

    public void setName(String name) {
        this.name = name;
    }

    public void setTeam(Team team) {
        this.team = team;
        team.addMember(this);
    }

    public Team getTeam() {
        return team;
    }
}
