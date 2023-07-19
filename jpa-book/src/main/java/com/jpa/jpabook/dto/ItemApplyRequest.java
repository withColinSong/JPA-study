package com.jpa.jpabook.dto;

import lombok.Data;

@Data
public class ItemApplyRequest {
    private final String name;
    private final int count;
    private final int price;
}
