package com.example.product.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Member {

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
}
