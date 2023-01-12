package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Member {
    @Id
    private String id;
    private String name;

    public Member(String id, String name, boolean vip) {
        this.id = id;
        this.name = name;
        this.vip = vip;
    }

    protected Member() {}

    @Convert(converter = BooleanToYNConverter.class)
    private boolean vip;

    public boolean isVip() {
        return vip;
    }
}
