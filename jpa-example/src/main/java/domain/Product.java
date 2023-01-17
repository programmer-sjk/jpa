package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
    @Id @GeneratedValue
    private Long id;

    private String name;

    public void setName(String name) {
        this.name = name;
    }
}
