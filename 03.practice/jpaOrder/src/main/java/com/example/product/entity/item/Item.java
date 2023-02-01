package com.example.product.entity.item;

import com.example.product.entity.Category;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private int stock;          // 재고
    private String itemName;    // 상품 이름
    private int price;          // 가격

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();
}
