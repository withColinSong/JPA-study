package com.jpa.jpabook.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private Integer price;
    private Integer count;

    @Builder
    public OrderItem(Member member, Item item, Integer price, Order order, Integer count) {
        this.member = member;
        this.item = item;
        this.price = price;
        this.order = order;
        this.count = count;
    }

    public void calculatePrice() {
        this.price = this.price * this.count;
    }

    public void calculateCount() {
        if(item.getCount() < 1) {
            throw new IllegalArgumentException("재고 부족");
        }

        item.modifyItemCount(count);
    }
}
