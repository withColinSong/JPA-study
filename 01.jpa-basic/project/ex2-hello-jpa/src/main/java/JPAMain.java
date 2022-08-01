import domain.Item;
import domain.Member;
import domain.Order;
import domain.OrderItem;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class JPAMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            // member
            Member member = new Member();
            member.setName("song");
            em.persist(member);

            // 아이템
            Item item = new Item();
            item.setName("Iphone");
            item.setPrice(1000000);
            item.setStockQuantity(5);
            em.persist(item);

            Item item2 = new Item();
            item2.setName("pencil");
            item2.setPrice(160000);
            item2.setStockQuantity(3);
            em.persist(item2);

            OrderItem orderItem = new OrderItem();
            orderItem.setItem(item);
            orderItem.setOrderPrice(item.getPrice());
            orderItem.setCount(1);
            em.persist(orderItem);

            OrderItem orderItem1 = new OrderItem();
            orderItem1.setItem(item2);
            orderItem1.setOrderPrice(item2.getPrice());
            orderItem1.setCount(1);
            em.persist(orderItem1);

            List<OrderItem> list = new ArrayList<>();
            list.add(orderItem);
            list.add(orderItem1);

            Order order = new Order();
            order.setOrderItems(list);
            order.setStatus(0);
            order.setMember(member);
            em.persist(order);


            tx.commit();
        } catch(Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
