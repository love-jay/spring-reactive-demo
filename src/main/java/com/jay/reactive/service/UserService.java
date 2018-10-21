package com.jay.reactive.service;

import com.jay.reactive.domain.User;
import com.jay.reactive.query.Page;
import com.jay.reactive.query.UserQuery;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface UserService {

    Mono<User> insert(User user);

    Mono<Page<User>> list(UserQuery userQuery);

    Flux<User> insertAll(List<User> users);

}
