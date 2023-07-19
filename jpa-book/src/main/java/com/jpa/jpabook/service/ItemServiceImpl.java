package com.jpa.jpabook.service;

import com.jpa.jpabook.domain.Item;
import com.jpa.jpabook.dto.ItemApplyDto;
import com.jpa.jpabook.dto.ItemModifyDto;
import com.jpa.jpabook.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Transactional
    public void apply(ItemApplyDto dto) {
        itemRepository.save(dto.toEntity());
    }

    @Override
    @Transactional
    public Item modify(ItemModifyDto dto) {
        Item item = itemRepository.findById(dto.getId()).orElseThrow();
        return item.modifyItem(dto.getName(),dto.getCount(), dto.getPrice());
    }

}
