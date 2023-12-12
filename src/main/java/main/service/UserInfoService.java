package main.service;

import main.model.User;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import reactor.core.publisher.Mono;


public interface UserInfoService {
    Mono<User> getUser(Jwt jwt);
}
