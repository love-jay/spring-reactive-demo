package com.jay.reactive.controller;

import com.jay.reactive.domain.User;
import com.jay.reactive.query.Page;
import com.jay.reactive.query.UserQuery;
import com.jay.reactive.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/add/{name}")
    public Mono<User> add(@PathVariable("name") String name) {
        return userService.insert(new User(UUID.randomUUID().toString(), name));
    }

    @PostMapping("/list")
    public Mono<Page<User>> list(@RequestBody UserQuery userQuery) {
        return userService.list(userQuery);

    }

}
