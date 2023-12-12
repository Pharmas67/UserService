package main.service;

import main.model.User;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import reactor.core.publisher.Mono;


public interface UserInfoService {
    Mono<User> getUser(OAuth2ResourceServerProperties.Jwt jwt);
}
