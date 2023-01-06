package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Member {
    @Id @GeneratedValue
    private String id;
    private String name;

    @ManyToOne
    private Team team;

    public String getName() {
        return name;
    }

    public Team getTeam() {
        return team;
    }
}
