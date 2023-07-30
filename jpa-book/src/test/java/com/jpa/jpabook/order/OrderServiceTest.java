package com.jpa.jpabook.order;

import com.jpa.jpabook.domain.Item;
import com.jpa.jpabook.domain.Member;
import com.jpa.jpabook.domain.Order;
import com.jpa.jpabook.domain.OrderItem;
import com.jpa.jpabook.enums.OrderStatus;
import com.jpa.jpabook.repository.ItemRepository;
import com.jpa.jpabook.repository.OrderItemRepository;
import com.jpa.jpabook.repository.OrderRepository;
import com.jpa.jpabook.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class OrderServiceTest {

    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;
    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderServiceTest(OrderRepository orderRepository, ItemRepository itemRepository, UserRepository userRepository, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @Test
    @Transactional
    void OrderItem() {

        Item item = itemRepository.findById(1L).orElseThrow();
        Member member = userRepository.findByEmail("song@dev1.com");

        // 주문하기
        Order order = Order.builder()
                .member(member)
                .status(OrderStatus.ORDER)
                .createAt(LocalDateTime.now())
                .build();

        orderRepository.save(order);

        OrderItem orderItem = OrderItem
                .builder()
                .count(2)
                .order(order)
                .item(item)
                .price(item.getPrice())
                .member(member)
                .build();

        orderItem.calculatePrice();
        orderItem.calculateCount();

        orderItemRepository.save(orderItem);

        assertThat(orderItem.getPrice()).isEqualTo(item.getPrice() * orderItem.getCount());

    }

    @Test
    @Transactional
    void orderList() {
        Member member = userRepository.findByEmail("song@dev1.com");
        Order order = orderRepository.findByMemberId(member.getId());
        assertThat(order.getOrderItemList().size()).isEqualTo(1);
    }
}