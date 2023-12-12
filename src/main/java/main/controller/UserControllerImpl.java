package main.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import main.model.User;
import main.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserControllerImpl implements UserController {

    final private UserService service;

    @PutMapping(
            path="/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    @Override
    public Mono<User> createUser(@RequestBody User user) {
        return service.createUser(user);
    }

    @GetMapping(
            path="/user/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Override
    public Mono<User> getUserById(@PathVariable UUID id) {
        return service.getUserById(id);
    }

    @PostMapping(
            path="/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    @Override
    public Mono<User> updateUser(@RequestBody User user) {
        return service.updateUser(user);
    }

    @DeleteMapping(
            path="/user/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    @Override
    public Mono<Void> deleteUserById(@PathVariable UUID id) {
        return service.deleteUserById(id);
    }
}
