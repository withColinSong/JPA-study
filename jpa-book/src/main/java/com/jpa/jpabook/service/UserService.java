package com.jpa.jpabook.service;

import com.jpa.jpabook.domain.Member;

import java.util.List;

public interface UserService {
    boolean join(Member member);
    List<Member> list();
}
