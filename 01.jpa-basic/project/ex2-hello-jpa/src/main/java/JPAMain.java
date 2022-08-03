import domain.Inheritance.Book;
import domain.Inheritance.MainItem;
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
            Book book = new Book();
            book.setName("자료구조와 함께 배우는 알고리즘 입문");
            book.setPrice(15000);
            book.setAuthor("강민");
            book.setISBN("234234");

            em.persist(book);
            em.flush();

            tx.commit();
        } catch(Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
