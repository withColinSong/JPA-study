package com.jpa.jpabook.service;

import com.jpa.jpabook.domain.Member;
import com.jpa.jpabook.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public boolean join(Member member) {
        boolean isExist = Objects.isNull(userRepository.findByEmail(member.getEmail()));
        if(isExist) {
            userRepository.save(member);
        }
        return isExist;
    }

    @Override
    public List<Member> list() {
        return userRepository.findAll();
    }
}
