import domain.Inheritance.Book;
import domain.Inheritance.MainItem;
import domain.Item;
import domain.Member;
import domain.Order;
import domain.OrderItem;
import domain.cascade.Child;
import domain.cascade.Parent;

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
            Parent parent = new Parent();
            Child child1 = new Child();
            Child child2 = new Child();

            parent.addChild(child1);
            parent.addChild(child2);

            em.persist(parent);
            em.persist(child1);
            em.persist(child2);

            tx.commit();

        } catch(Exception e) {
            tx.rollback();
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }

        emf.close();
    }
}
