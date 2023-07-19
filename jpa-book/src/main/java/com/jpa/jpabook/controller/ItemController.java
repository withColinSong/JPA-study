package com.jpa.jpabook.controller;

import com.jpa.jpabook.dto.ItemApplyDto;
import com.jpa.jpabook.dto.ItemApplyRequest;
import com.jpa.jpabook.dto.ItemModifyDto;
import com.jpa.jpabook.dto.ItemModifyRequest;
import com.jpa.jpabook.service.ItemServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/item")
@RequiredArgsConstructor
@RestController
public class ItemController {

    private final ItemServiceImpl itemService;
    @PostMapping("/apply")
    public ResponseEntity<?> save(@RequestBody ItemApplyRequest itemRequest) {

        ItemApplyDto dto = ItemApplyDto.builder()
                .name(itemRequest.getName())
                .count(itemRequest.getCount())
                .price(itemRequest.getPrice())
                .build();

        itemService.apply(dto);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> modify(@PathVariable Long id, @RequestBody ItemModifyRequest modifyRequest) {
        ItemModifyDto itemModifyDto = ItemModifyDto
                .builder()
                .id(id)
                .name(modifyRequest.getName())
                .price(modifyRequest.getPrice())
                .count(modifyRequest.getCount())
                .build();

        itemService.modify(itemModifyDto);
        return ResponseEntity.ok().build();
    }
}
