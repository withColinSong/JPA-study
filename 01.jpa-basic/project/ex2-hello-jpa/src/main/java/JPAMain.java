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

            tx.commit();
        } catch(Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
