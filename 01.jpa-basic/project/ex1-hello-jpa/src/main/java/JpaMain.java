import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


/**
 *
 * EntityManagerFactory
 * EntityManager 1회용 객체
 * - 쓰레드 간의 공유 하지 않는다.
 *
 * @Author yj.song
 */
public class JpaMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            /**
             * 저장 persist
             * 조회 find
             * 수정 member.set.. -> 영속상태에서만 가능하다.
             * 삭제 remove
             */

            Member member = new Member();
            member.setId("1");
            member.setName("song");
            member.setAge(15);

            em.persist(member);

            // 조회
            em.find(Member.class, member.getId());

            // 준영속
            // em.detach(member);

            // 수정 - 영속상태에서만 가능하다.
            member.setAge(20);

            // 삭제
            em.remove(member);

            tx.commit();
        } catch(Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }

}
