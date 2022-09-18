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
        Team team1 = Team.builder()
                .name("Development")
                .build();

        Team team2 = Team.builder()
                .name("Design")
                .build();

        Member member1 = Member.builder()
                .name("song")
                .build();

        Member member2 = Member.builder()
                .name("kim")
                .build();

//        team1.addMember(member1);
//        team2.addMember(member2);

        em.persist(member1);
        em.persist(member2);
        em.persist(team1);
        em.persist(team2);

        em.flush();
        em.clear();

        // when
        Member findMember = em.find(Member.class, member1.getId());
        Team findTeam = em.find(Team.class, team1.getId());

        // then
        Assertions.assertEquals(
                findMember.getName(),
                findTeam.getMembers()
                        .stream()
                        .filter(x-> x.getId().equals(member1.getId()))
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