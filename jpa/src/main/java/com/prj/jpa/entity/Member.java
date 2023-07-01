package com.prj.jpa.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String name;
    private String age;

    @Builder
    public Member(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public Member() {

    }

    public void setName(String name) {
        this.name = name;
    }
}
