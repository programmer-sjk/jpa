package jpabook.jpashop.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
    @Column
    private String city;
    private String street;

    protected Address() {}

    public Address(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }
}
