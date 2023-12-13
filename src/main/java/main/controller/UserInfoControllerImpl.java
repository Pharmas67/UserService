package main.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import main.model.User;
import main.service.UserInfoService;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserInfoControllerImpl implements UserInfoController{

    final private UserInfoService service;

    @PostMapping(
            path="/getUser",
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    @Override
    public Mono<User> getUser(@RequestBody Jwt jwt) {
        return service.getUser(jwt);
    }
}
