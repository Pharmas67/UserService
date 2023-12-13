package main.service;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import main.Repositories.UserRepository;
import main.model.User;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
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

        log.debug("User with id {}," + user.getId().toString());

        var r2Template = new R2dbcEntityTemplate(conn);
        return r2Template.insert(user);
    }

    @Override
    public Mono<User> updateUser(User user) {
        return repo.save(user);
    }

    @Override
    public Mono<Void> deleteUserById(UUID id) {
        return repo.deleteById(id);
    }
}
