package com.exampol.santiago_valentina_microservices.repository;

import com.exampol.santiago_valentina_microservices.model.User;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends R2dbcRepository<User, Long> {
    Mono<User> findByEmail(String email);
}
