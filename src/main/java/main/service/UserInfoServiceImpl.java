package main.service;

import io.r2dbc.spi.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import main.Repositories.UserRepository;
import main.model.User;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserInfoServiceImpl implements UserInfoService{

    final private UserRepository repo;
    final private ConnectionFactory conn;

    @Override
    public Mono<User> getUser(OAuth2ResourceServerProperties.Jwt jwt) {
        var principals = jwt.;

        return null;
    }
}
