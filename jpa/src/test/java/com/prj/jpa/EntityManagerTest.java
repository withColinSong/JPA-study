package com.prj.jpa;

import com.prj.jpa.entity.Member;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
@Transactional
public class EntityManagerTest {

    @PersistenceContext
    private EntityManager em;

    @Test
    void 엔티티_조회_1차캐시() {
        // 비영속
        Member song = Member.builder()
                .name("song")
                .age("20").build();

        // 엔티티 영속
        em.persist(song);

        // select 문이 나가지 않고 1차 캐시 결과값을 가져온다.
        Member member = em.find(Member.class, song.getId());
        Assertions.assertEquals(song, member);
    }

    @Test
    void db_조회() {
        Member member1 = em.find(Member.class, 1L);
    }

    @Test
    void 영속_엔티티_동일성_보장() {
        Member member1 = em.find(Member.class, 1L);
        Member member2 = em.find(Member.class, 1L);

        Assertions.assertEquals(member1, member2);
    }

    @Test
    void 쓰기_지연() {
        Member member1 = Member.builder()
                .name("song1")
                .age("20").build();

        Member member2 = Member.builder()
                .name("song2")
                .age("25").build();

        em.persist(member1);
        em.persist(member2);

        /**
         * commit 시 insert batch 처리됨.
         * insert
         *     into
         *         member
         *         (age,name,id)
         *     values
         *         (?,?,default),
         *         (?,?,default);
         */
    }

    @Test
    @Transactional
    @Rollback(value = false)
    void 변경_감지() {
        Member member = em.find(Member.class, 1L);
        member.setName("changeSong");
        /**
         * Rollback이 true이면 update문 안나감.
         * update
         *         member
         *     set
         *         age=?,
         *         name=?
         *     where
         *         id=?
         */

    }
}
