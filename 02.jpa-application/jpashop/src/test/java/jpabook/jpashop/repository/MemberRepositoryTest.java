package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class MemberRepositoryTest {


    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("MemberRepository테스트")
    public void  jpa_test() {
      // given

        Member member = new Member();
        member.setName("song");

        // mac 단축키 => command + option + v
        Long memberId = memberRepository.save(member);

        // when
        Member findMember = memberRepository.find(memberId);

        // then
        Assertions.assertThat(findMember.getId()).isEqualTo(memberId);
        Assertions.assertThat(findMember.getName()).isEqualTo(member.getName());


    }

}