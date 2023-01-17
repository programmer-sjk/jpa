package domain;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {
    @Id @GeneratedValue
    protected Long id;
    protected String name;
}
