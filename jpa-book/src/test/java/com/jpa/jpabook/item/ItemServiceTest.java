package com.jpa.jpabook.item;

import com.jpa.jpabook.domain.Item;
import com.jpa.jpabook.dto.ItemModifyDto;
import com.jpa.jpabook.repository.ItemRepository;
import com.jpa.jpabook.service.ItemService;
import com.jpa.jpabook.service.ItemServiceImpl;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class ItemServiceTest {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemService itemService;


    @Test
    @Transactional
    @Rollback(false)
    void createItems() {
        List<Item> items = new ArrayList<>();

        items.add(Item.builder()
                .name("ipad")
                .count(5)
                .price(1000000)
                .build());

        items.add(Item.builder()
                .name("macbook")
                .count(3)
                .price(3500000)
                .build());

        items.add(Item.builder()
                .name("iphone")
                .count(10)
                .price(800000)
                .build());

        items.add(Item.builder()
                .name("mouse")
                .count(4)
                .price(100000)
                .build());

        List<Item> saves = itemRepository.saveAll(items);
        assertThat(saves.size()).isEqualTo(4);

    }

    @Test
    @Transactional
    @Rollback(false)
    void modifyItem() {
        ItemModifyDto dto = new ItemModifyDto(1L, "test", 3, 4);
        Item modify = itemService.modify(dto);
        assertThat(dto.getId().compareTo(modify.getId()));
    }
}