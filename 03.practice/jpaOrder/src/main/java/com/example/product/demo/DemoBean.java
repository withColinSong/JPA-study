package com.example.product.demo;

import com.example.product.entity.Member;
import com.example.product.repository.MemberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class DemoBean {

    private final MemberRepository memberRepository;

    public DemoBean(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public CommandLineRunner demo(MemberRepository repository) {
        return (args) -> {

            repository.save(Member.builder()
                            .name("song1")
                            .city("seoul")
                            .street("목동")
                            .zipCode(00001)
                            .build());

            repository.save(Member.builder()
                            .name("song2")
                            .city("seoul")
                            .street("신정역")
                            .zipCode(00002)
                            .build());

            repository.save(Member.builder()
                            .name("song3")
                            .city("seoul")
                            .street("오목교")
                            .zipCode(00003)
                            .build());

        };
    }
}
