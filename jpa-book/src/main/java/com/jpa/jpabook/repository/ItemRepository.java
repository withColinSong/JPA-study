package com.jpa.jpabook.repository;

import com.jpa.jpabook.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
