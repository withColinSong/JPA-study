package com.jpa.jpabook.user;

import com.jpa.jpabook.domain.Member;
import com.jpa.jpabook.repository.UserRepository;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void createUsers() {
        List<Member> users = new ArrayList<>();
        users.add(Member.builder()
                .name("song")
                .email("song@dev1.com")
                .address("헬로우 구")
                .build());

        users.add(Member.builder()
                .name("kim")
                .email("kim@dev1.com")
                .address("헬로우 행복동")
                .build());

        List<Member> members = userRepository.saveAll(users);
        assertThat(members.size()).isEqualTo(2);

    }
}
