package com.jpastudy.demo.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
class EntityTest {

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    @Rollback(false)
    public void 테스트() {
        //given
        Team team = Team.builder()
                .name("Development")
                .build();

        System.out.println(team.getId());

        Member member = Member.builder()
                .team(team)
                .name("song")
                .build();

        em.persist(team);
        em.persist(member);

        em.flush();
        em.clear();

        // when
        Member findMember = em.find(Member.class, member.getId());

        // then
//        Assertions.assertEquals(findMember.getTeam().getName(), team.getName());

    }

    @Test
    @Transactional
    @Rollback(false)
    public void  테스트코드() {
        // given


        // when


        // then


    }
}