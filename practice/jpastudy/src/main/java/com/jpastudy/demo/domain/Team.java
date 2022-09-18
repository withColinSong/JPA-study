package com.jpastudy.demo.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Team {

    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;

    @OneToMany
    @JoinColumn(name = "TEAM_ID")
    private List<Member> members = new ArrayList<>();

    @Builder
    public Team(String name) {
        this.name = name;
    }

    // 편의 메서드
    public void addMember(Member member) {
        if(this.getMembers() != null) {
            this.members.remove(member);
        }
        this.members.add(member);
    }

}