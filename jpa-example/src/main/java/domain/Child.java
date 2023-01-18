package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Child {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private Parent parent;

    public void setParent(Parent parent) {
        this.parent = parent;
    }
}
