package com.jpastudy.demo.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member {

    @Id @GeneratedValue
    private Long id;
    private String name;

    @OneToOne(fetch = FetchType.LAZY,
              mappedBy = "member")
    private Locker locker;


    ////////////////////
    // constructor, getter, setter
    ////////////////////

    @Builder
    public Member(String name) {
        this.name = name;
    }


    // 편의메서드
    public void addLocker(Locker locker) {
        this.locker = locker;
    }
}
