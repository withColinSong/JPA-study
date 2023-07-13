package com.jpa.jpabook.dto;

import com.jpa.jpabook.domain.Member;
import lombok.Data;

@Data
public class MemberJoinDto {
    private String name;
    private String email;
    private String address;

    public Member toEntity() {
        return Member.builder()
                .name(name)
                .email(email)
                .address(address)
                .build();
    }
}
