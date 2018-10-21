package com.jay.reactive.service.impl;

import com.jay.reactive.domain.User;
import com.jay.reactive.query.BaseQuery;
import com.jay.reactive.query.Page;
import com.jay.reactive.query.UserQuery;
import com.jay.reactive.repository.UserRepositry;
import com.jay.reactive.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final ReactiveMongoOperations reactiveMongoOperations;

    private final UserRepositry userRepositry;

    @Autowired
    public UserServiceImpl(ReactiveMongoOperations reactiveMongoOperations, UserRepositry userRepositry) {
        this.reactiveMongoOperations = reactiveMongoOperations;
        this.userRepositry = userRepositry;
    }

    @Override
    public Mono<User> insert(User user) {
//        return reactiveMongoOperations.insert(user);
        return userRepositry.insert(user);
    }

    @Override
    public Mono<Page<User>> list(UserQuery userQuery) {
        return query(userQuery)
                .flatMap(query -> Mono.zip(reactiveMongoOperations.count(query, User.class), reactiveMongoOperations.find(query, User.class)
                        .collectList())
                        .map(results -> {
                            return new Page<>(userQuery.getCurrentPage(), userQuery.getPageSize(), results.getT1(), results.getT2());
                        }));
    }

    private Mono<Query> query(UserQuery userQuery) {
        return Mono.create(queryMonoSink -> {
            Query query = new Query();
            if (StringUtils.hasText(userQuery.getUserGuid())) {
                query.addCriteria(Criteria.where("userGuid").is(userQuery.getUserGuid()));
            }
            queryMonoSink.success(query);
        });
    }

    @Override
    public Flux<User> insertAll(List<User> users) {
        return reactiveMongoOperations.insertAll(users);
    }
}
