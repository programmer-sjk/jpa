package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    public String getId() {
        return id;
    }
}
