package com.jpa.jpabook.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer count; // 재고
    private Integer price; // 가격

    @Builder
    public Item(String name, Integer count, Integer price) {
        this.name = name;
        this.count = count;
        this.price = price;
    }
}
