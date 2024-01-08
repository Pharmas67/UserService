package main.service;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import main.Repositories.UserRepository;
import main.model.User;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{

    final private UserRepository repo;
    final private ConnectionFactory conn;

    @Override
    public Mono<User> createUser(User user) {
        user.setId(UUID.randomUUID());

        var r2Template = new R2dbcEntityTemplate(conn);
        return r2Template.insert(user);

    }

    @Override
    public Mono<User> updateUser(Jwt jwt) {

        var payload = jwt.getClaims();

        jwt.getClaimAsString()

        User user = (User) payload.get("email");

        var r2Template = new R2dbcEntityTemplate(conn);
        return r2Template.update(user);
    }

    @Override
    public Mono<Void> deleteUserById(Jwt jwt) {

        var payload = jwt.getClaims();

        User user = (User) payload.get("email");

        //UUID id = (UUID) user.id;
        var r2Template = new R2dbcEntityTemplate(conn);
        r2Template.delete(user);
        return null;
    }
}
