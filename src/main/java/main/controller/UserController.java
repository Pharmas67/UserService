package main.controller;

import main.model.User;
import org.springframework.security.oauth2.jwt.Jwt;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface UserController {
    Mono<User> createUser(User user);
    Mono<User> updateUser(Jwt jwt);
    Mono<Void> deleteUserById(Jwt jwt);
}
