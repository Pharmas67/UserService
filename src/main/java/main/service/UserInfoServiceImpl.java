package main.service;

import io.r2dbc.spi.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.jwt.Jwt;
import lombok.extern.slf4j.Slf4j;
import main.Repositories.UserRepository;
import main.model.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserInfoServiceImpl implements UserInfoService{

    final private UserRepository repo;
    final private ConnectionFactory conn;

    @Override
    public Mono<User> getUser(Jwt jwt) {
        var payload = jwt.getClaims();

        UUID id = (UUID) payload.get("id");

        return repo.findById(id);
    }
}
