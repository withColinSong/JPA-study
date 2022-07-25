import domain.Member;
import domain.Order;

import javax.persistence.*;

public class JPAMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Order order = new Order();

        System.out.println(
            em.find(Member.class, 1L)
        );
//        try {
//            tx.begin();
//
//            Member member = new Member();
//            member.setName("song");
//            System.out.println("================A");
//            em.persist(member);
//            System.out.println("================B");
//
//            Order order = new Order();
//            order.setMember(member);
//            System.out.println("================C");
//            em.persist(order);
//            System.out.println("================D");
//            em.flush();
//
//            tx.commit();
//        } catch(Exception e) {
//            tx.rollback();
//        } finally {
//            em.close();
//        }
//
//        emf.close();
    }
}
