package main.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import main.model.User;
import main.service.UserInfoService;
import org.springframework.boot;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserInfoControllerImpl implements UserInfoController{

    final private UserInfoService service;

    @GetMapping(
            path="/getUser",
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    @Override
    public Mono<User> getUser(OAuth2ResourceServerProperties.Jwt jwt) {
        return null;
    }
}
