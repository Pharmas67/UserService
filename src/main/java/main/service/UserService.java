package main.service;

import main.model.User;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface UserService {
    Mono<User> createUser(User user);
    Mono<User> updateUser(User user);
    Mono<Void> deleteUserById(UUID id);
}
