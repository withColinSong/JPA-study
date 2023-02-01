package com.example.product.entity;

import lombok.Getter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public class BaseEntity {

    private LocalDateTime createDate;       // 등록일
    private LocalDateTime lastModifiedDate;  // 수정일
    
}
