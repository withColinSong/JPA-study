package com.jpa.jpabook.repository;

import com.jpa.jpabook.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByMemberId(Long memberId);
}
