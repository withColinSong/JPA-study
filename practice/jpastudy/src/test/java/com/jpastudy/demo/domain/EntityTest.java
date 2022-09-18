package com.jpastudy.demo.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
class EntityTest {

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    @Rollback(false)
    public void 테스트() {
        //given
        Member member1 = Member.builder()
                .name("song")
                .build();

        Locker locker = new Locker();
        member1.addLocker(locker);

        em.persist(locker);
        em.persist(member1);

        em.flush();
        em.clear();

        // when
        Member findMember = em.find(Member.class, member1.getId());
        Locker findLocker = em.find(Locker.class, locker.getId());

        // then
        Assertions.assertEquals(
                findMember.getLocker().getId(),
                findLocker.getMember().getLocker().getId());
    }

}