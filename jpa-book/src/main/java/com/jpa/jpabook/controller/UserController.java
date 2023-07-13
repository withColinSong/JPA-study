package com.jpa.jpabook.controller;

import com.jpa.jpabook.domain.Member;
import com.jpa.jpabook.dto.MemberJoinDto;
import com.jpa.jpabook.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/api/v1/user")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/join")
    private ResponseEntity<?> join(@RequestBody MemberJoinDto dto) {
        boolean result  = userService.join(dto.toEntity());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/list")
    private ResponseEntity<?> list() {
        List<Member> list = userService.list();
        return ResponseEntity.ok(list);
    }
}
