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


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID",
                updatable = false,
                insertable = false)
    private Team team;

    ////////////////////
    // constructor, getter, setter
    ////////////////////

    @Builder
    public Member(String name) {
        this.name = name;
    }

    public void updateSetName(String name) {
        this.name = name;
    }

}
