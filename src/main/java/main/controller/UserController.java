package main.controller;

import main.model.User;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface UserController {
    Mono<User> createUser(User user);
    Mono<User> updateUser(User user);
    Mono<Void> deleteUserById(UUID id);
}
