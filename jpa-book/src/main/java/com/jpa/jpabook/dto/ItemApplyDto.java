package com.jpa.jpabook.dto;

import com.jpa.jpabook.domain.Item;
import lombok.Builder;

public class ItemApplyDto {
    private String name;
    private int count;
    private int price;

    public ItemApplyDto() { }

    @Builder
    public ItemApplyDto(String name, int count, int price) {
        this.name = name;
        this.count = count;
        this.price = price;
    }

    public Item toEntity() {
        return Item.builder()
                .name(name)
                .count(count)
                .price(price)
                .build();
    }
}
