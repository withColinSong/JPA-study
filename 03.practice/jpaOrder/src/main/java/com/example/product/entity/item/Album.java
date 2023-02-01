package com.example.product.entity.item;

import javax.persistence.*;

@Entity
@DiscriminatorValue("A")
public class Album extends Item {

    private String artist;
    private String etc;

}
