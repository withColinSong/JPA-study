package jpabook.jpashop.domain.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("회원가입")
    @Rollback(false)
    public void  회원가입() throws Exception{
        // given
        Member member = new Member();
        member.setName("song");

        // when
        Long findId = memberService.join(member);

        // Transactional rollback 시  insert 하지 않기 때문에 EntityManager을 받아 flush를 하면 db에 쿼리가 나가는 것을 확인할 수 있다.
        // then
        assertEquals(member, memberRepository.findOne(findId));

    }

    @Test
    @DisplayName("중복회원예외처리")
    public void  중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("song");

        Member member2 = new Member();
        member2.setName("song");

        // when
        memberService.join(member1);

        // then
        assertThrows(IllegalStateException.class, () -> {
            memberService.join(member2);
        });

    }
}