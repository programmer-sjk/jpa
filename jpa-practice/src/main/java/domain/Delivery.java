package domain;

import javax.persistence.*;

@Entity
public class Delivery {
    @Id @GeneratedValue
    private Long id;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    @OneToOne(mappedBy = "delivery")
    private Order order;
}
