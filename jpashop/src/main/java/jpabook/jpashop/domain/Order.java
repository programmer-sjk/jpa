package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="ORDERS")
public class Order {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private Member member;

    public void setMember(Member member) {
        this.member = member;
    }

    public Long getId() {
        return id;
    }
}
