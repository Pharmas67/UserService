package main.controller;

import main.model.User;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.security.oauth2.jwt.Jwt;
import reactor.core.publisher.Mono;

public interface UserInfoController {

    Mono<User> getUser(Jwt jwt);
}
