package jpabook.jpashop.repository;

import jpabook.jpashop.domain.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderSearch {
    private String name;
    private OrderStatus orderStatus;
}
