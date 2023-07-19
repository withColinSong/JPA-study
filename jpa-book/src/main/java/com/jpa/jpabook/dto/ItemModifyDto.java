package com.jpa.jpabook.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ItemModifyDto {
    private Long id;
    private String name;
    private int count;
    private int price;

    @Builder
    public ItemModifyDto(Long id, String name, int count, int price) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
    }
}
