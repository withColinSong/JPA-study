package com.jpastudy.demo.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.stream.Collectors;

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

        Member member = Member.builder()
                .name("song")
                .build();

        member.addTeam(team); // 편의 메서드

        em.persist(team);
        em.persist(member);

        em.flush();
        em.clear();

        // when
        Member findMember = em.find(Member.class, member.getId());
        Team findTeam = em.find(Team.class, team.getId());

        // then
        Assertions.assertEquals(
                findMember.getName(),
                findTeam.getMembers()
                        .stream()
                        .map(Member::getName)
                        .collect(Collectors.joining())
        );

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