package domain;

import javax.persistence.*;

@Entity
public class Member {
    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }
}
