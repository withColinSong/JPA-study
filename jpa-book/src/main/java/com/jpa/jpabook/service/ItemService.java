package com.jpa.jpabook.service;

import com.jpa.jpabook.domain.Item;
import com.jpa.jpabook.dto.ItemApplyDto;
import com.jpa.jpabook.dto.ItemModifyDto;

public interface ItemService {
    void apply(ItemApplyDto dto);

    Item modify(ItemModifyDto dto);
    // 상품 조회
}
