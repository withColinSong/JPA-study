package com.jpa.jpabook.domain;

import com.jpa.jpabook.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItemList = new ArrayList<>();

    @Enumerated(value = EnumType.STRING)
    private OrderStatus status;
    private LocalDateTime createAt;

    @Builder
    public Order(Member member, OrderStatus status, LocalDateTime createAt) {
        this.member = member;
        this.status = status;
        this.createAt = createAt;
    }
}
