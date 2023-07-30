package com.jpa.jpabook.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/order")
@RestController
public class OrderController {

    @PostMapping("/create")
    public ResponseEntity<?> order() {
        return ResponseEntity.ok().build();
    }
}
