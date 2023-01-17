package domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public abstract class BaseEntity {
    private Date createdDate;
    private Date lastModifiedDate;
}
