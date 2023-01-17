package domain;

import org.hibernate.annotations.OnDelete;

import javax.persistence.*;

@Entity
public class CategoryItem {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
