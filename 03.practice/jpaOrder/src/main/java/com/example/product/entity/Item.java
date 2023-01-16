package com.example.product.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Item {

    @Id
    @GeneratedValue
    private Long id;

    private int stock;          // 재고
    private String itemName;    // 상품 이름
    private int price;          // 가격

}
