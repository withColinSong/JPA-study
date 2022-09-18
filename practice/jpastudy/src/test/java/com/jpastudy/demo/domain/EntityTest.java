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

        Member member = Member.builder()
                .name("song")
                .build();

        Product product = Product.builder()
                            .name("IPAD")
                            .build();

        member.getProducts().add(product);

        em.persist(member);
        em.persist(product);

    }

}