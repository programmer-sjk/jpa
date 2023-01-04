package jpabook.jpashop.domain;

import javax.persistence.*;

@Entity
public class Parent {
    @EmbeddedId
    private ParentId id;

    private String name;

    public ParentId getId() {
        return id;
    }

    public void setId(ParentId id) {
        this.id = id;
    }
}
