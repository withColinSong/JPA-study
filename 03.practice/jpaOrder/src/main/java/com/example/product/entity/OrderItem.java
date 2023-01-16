package com.example.product.entity;

import javax.persistence.*;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    private Long id;
    private int count;      // 구매양
    private int price;      // 구매 금액

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;    // 주문 아이디

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;      // 아이템
}
