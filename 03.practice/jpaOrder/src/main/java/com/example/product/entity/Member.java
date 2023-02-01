package com.example.product.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
public class Member extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;

    private String city;
    private String street;
    private int zipCode;

    @OneToMany(mappedBy = "member")
    private List<Order> orders;

    protected Member() { }

    @Builder
    public Member(String name, String city, String street, int zipCode) {
        this.name = name;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
    }
}
