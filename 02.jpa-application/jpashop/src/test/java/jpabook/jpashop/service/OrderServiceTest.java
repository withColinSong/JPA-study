package jpabook.jpashop.service;

import jpabook.jpashop.domain.*;
import jpabook.jpashop.domain.enums.OrderStatus;
import jpabook.jpashop.domain.exception.NotEnoughStockException;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.repository.OrderRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class OrderServiceTest {

    @Autowired
    EntityManager em;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRepository;

    @Test
    public void 상품주문 () {
        // given
        Member member = createMember("회원1");
        Book book = createBook("JPA", 10000, 10);

        // when
        int orderCount=  2;
        Long orderId = orderService.Order(member.getId(), book.getId(), orderCount);
        Order getOrder = orderRepository.findOne(orderId);

        // then
        Assertions.assertThat(getOrder.getStatus()).isEqualTo(OrderStatus.ORDER);
        Assertions.assertThat(1).isEqualTo(getOrder.getOrderItems().size());
        Assertions.assertThat(10000 * orderCount).isEqualTo(getOrder.getTotalPrice());

    }

    private Book createBook(String name, int price, int stockQuantity) {
        Book book = new Book();
        book.setName(name);
        book.setPrice(price);
        book.setStockQuantity(stockQuantity);
        em.persist(book);
        return book;
    }

    //command + option + p => 파라미터 변수화
    private Member createMember(String name) {
        Member member = new Member();
        member.setName(name);
        member.setAddress(new Address("서울", "헬로우" , "123-123"));
        em.persist(member);
        return member;
    }

    @Test
    public void 상품주문_재고수량초과 () {
        // given
        Member member = createMember("회원1");
        Book book = createBook("JPA", 10000, 10);

        // when
        int orderCount =  100;
        NotEnoughStockException exception = assertThrows(NotEnoughStockException.class, () ->
                                                            OrderItem.createOrderItem(book, book.getPrice(), orderCount));

        // then
        Assertions.assertThat("need more stock").isEqualTo(exception.getMessage());

    }

    @Test
    public void 상품주문취소 () {
        // given
        Member member = createMember("회원1");
        Book book = createBook("JPA", 10000, 10);

        Long orderId = orderService.Order(member.getId(), book.getId(), 10);

        // when
        orderService.cancelOrder(orderId);

        // then
        Order order = orderRepository.findOne(orderId);
        Assertions.assertThat(order.getStatus()).isEqualTo(OrderStatus.CANCEL);

    }
}