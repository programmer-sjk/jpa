package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Member {
    @Id
    private String id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID", nullable = false)
    private Team team;

    public String getName() {
        return name;
    }

    public Team getTeam() {
        return team;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setId(String id) {
        this.id = id;
    }
}
