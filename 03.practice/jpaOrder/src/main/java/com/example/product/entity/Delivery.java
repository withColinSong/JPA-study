package com.example.product.entity;

import com.example.product.enums.DeliveryStatus;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Delivery {

    @Id
    @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    private String city;
    private String street;
    private String zopCode;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

}
