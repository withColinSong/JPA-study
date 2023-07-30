package com.jpa.jpabook.repository;

import com.jpa.jpabook.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    OrderItem findByMemberId(Long memberId);
}
