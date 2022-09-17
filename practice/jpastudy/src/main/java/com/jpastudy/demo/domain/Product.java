package com.jpastudy.demo.domain;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Product {

    @Id @GeneratedValue
    private Long id;
    private String name;

    ////////////////////
    // constructor, getter, setter
    ////////////////////

    @Builder
    public Product(String name) {
        this.name = name;
    }
}
