package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Parent {
    @Id @GeneratedValue
    @Column(name = "PARENT_ID")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "parent", orphanRemoval = true, cascade = CascadeType.PERSIST)
    private List<Child> childs = new ArrayList<>();

    public List<Child> getChilds() {
        return childs;
    }
}
