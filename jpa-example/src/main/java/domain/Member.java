package domain;

import javax.persistence.*;

@Entity
public class Member {
    @Id @GeneratedValue
    private Long id;
}
