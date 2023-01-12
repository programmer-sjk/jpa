package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Team {
    @Id
    private String id;

    @OneToMany
    @JoinColumn
    private Collection<Member> members = new ArrayList<>();

    public Collection<Member> getMembers() {
        return members;
    }

    public void setId(String id) {
        this.id = id;
    }
}
