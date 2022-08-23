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

        tx.begin();

        try {
            // 프록시 테스트
            Member member = em.getReference(Member.class, 1L);
            System.out.println(member.getClass()); // class domain.Member$HibernateProxy$sNgDwKnZ
            System.out.println(member.getName()); // 이때 쿼리가 실행된다.

        } catch(Exception e) {
            tx.rollback();
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }

        emf.close();
    }
}
