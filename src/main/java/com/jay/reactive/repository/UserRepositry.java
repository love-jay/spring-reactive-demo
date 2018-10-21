package com.jay.reactive.repository;

import com.jay.reactive.domain.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.io.Serializable;

public interface UserRepositry  extends ReactiveMongoRepository<User,Serializable>{



}
