package main.service;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import main.Repositories.UserRepository;
import main.model.User;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.relational.core.query.CriteriaDefinition;
import org.springframework.data.relational.core.query.Query;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static org.springframework.data.relational.core.query.Criteria.where;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{

    final private UserRepository repo;
    final private ConnectionFactory conn;

    @Override
    public Mono<User> createUser(User user) {
        user.setId(UUID.randomUUID());

        if(userExists(user.getEmail())){
            System.out.println("email already taken");
            return null;
        }

        var r2Template = new R2dbcEntityTemplate(conn);
        return r2Template.insert(user);
    }

    private boolean userExists(String email){
        var r2Template = new R2dbcEntityTemplate(conn);

        CriteriaDefinition criteria = where("email").is(email);
        Query query = Query.query(criteria);
        Mono cEmail = null;
        cEmail = r2Template.selectOne(query, Mono.class);
        cEmail.subscribe(
                entity-> {
                    System.out.println(entity);
                }
        );
        return false;
    }

    @Override
    public Mono<User> updateUser(Jwt jwt) {
        var r2Template = new R2dbcEntityTemplate(conn);

        User user = new User();
        user.setEmail(jwt.getClaimAsString("email"));
        user.setId(jwt.getClaim("id"));
        user.setName(jwt.getClaimAsString("name"));

        if(!userExists(user.getEmail())){
            System.out.println("User not found or false request");
            return null;
        } else {
            boolean result = false;
            if(result == Boolean.TRUE.equals(repo.existsById(user.getId()).block())){
                System.out.println("User not found or something went wrong");
                return null;
            }
        }
        return repo.save(user);
    }

    @Override
    public Mono<Void> deleteUserById(Jwt jwt) {
        var r2Template = new R2dbcEntityTemplate(conn);

        String email = jwt.getClaimAsString("email");
        UUID id = jwt.getClaim("id");

        if(!userExists(email)){
            System.out.println("User not found or false request");
            return null;
        } else {
            boolean result = false;
            if(result == Boolean.TRUE.equals(repo.existsById(id).block())){
                System.out.println("User not found or something went wrong");
                return null;
            }
        }
        return repo.deleteById(id);
    }
}
