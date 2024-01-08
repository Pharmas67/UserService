package main.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import main.model.User;
import main.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.jwt.Jwt;
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

    @PostMapping(
            path="/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    @Override
    public Mono<User> updateUser(@RequestBody Jwt jwt) {
        return service.updateUser(jwt);
    }

    @DeleteMapping(
            path="/deleteUser",
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    @Override
    public Mono<Void> deleteUserById(@RequestBody Jwt jwt) {
        return service.deleteUserById(jwt);
    }
}
