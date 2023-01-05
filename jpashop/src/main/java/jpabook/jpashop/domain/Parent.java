package jpabook.jpashop.domain;

import javax.persistence.*;

@Entity
public class Parent {
    @Id @GeneratedValue
    @Column(name = "PARENT_ID")
    private Long id;

    private String name;
}
