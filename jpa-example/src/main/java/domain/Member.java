package domain;

import javax.persistence.*;

@Entity
public class Member {
    @Id
    private Long id;
    private String name;
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
