package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Board {
    @Id @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "board")
    private BoardDetail boardDetail;
}
