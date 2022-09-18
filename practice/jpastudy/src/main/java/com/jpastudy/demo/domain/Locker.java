package com.jpastudy.demo.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Locker {

    @Id @GeneratedValue
    private Long id;

    ////////////////////
    // constructor, getter, setter
    ////////////////////

}
