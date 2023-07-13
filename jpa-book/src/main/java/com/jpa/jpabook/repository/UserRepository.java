package com.jpa.jpabook.repository;

import com.jpa.jpabook.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Member, Long> {

    Member findByEmail(String email);
}
