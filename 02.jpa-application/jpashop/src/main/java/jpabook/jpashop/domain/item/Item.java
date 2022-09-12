package jpabook.jpashop.domain.item;


import jpabook.jpashop.domain.exception.NotEnoughStockException;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long Id;

    private String name;
    private int price;
    private int stockQuantity;


    // 비지니스 로직
    // 데이터 로직에 있을 시 바람직하다.
    // setter를 만드는게 아니라 메서드를 추가해서 메서드의 비지니스 로직을 추가하는게 좋다.

    /**
     * stock 증가
     * @param quantity
     */
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    /**
     * stock 감소
     * 0보다 작을 때 Exception 처리
     * @param quantity
     */
    public void removeStock(int quantity) {
        int restStock = this.stockQuantity - quantity;
        if(restStock < 0) {
            throw new NotEnoughStockException("need more stock");
        }

        this.stockQuantity = restStock;
    }


}
