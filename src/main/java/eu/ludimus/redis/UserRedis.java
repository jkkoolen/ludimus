package eu.ludimus.redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import eu.ludimus.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Component
public class UserRedis extends AbstractRedis<User> {
    @Override
    public User save(final User user) {
        if(findByEmail(user.getEmail()) != null) {
            throw new AlreadyExistsException(String.format("Error, user with email %s already exists!", user.getEmail()));
        }
        return (User) run(jedis -> {
            boolean isNew = user.getId() == null;
            if(isNew) {
                user.preUpdate();
            } else {
                user.prePersist();
            }
            user.setId(getId(User.class, user.getId()));
            final String key = name() + ':' + user.getId();

            jedis.sadd(name() + ":keys", key);
            try {
                jedis.set(key, toJson(user));
                saveByEmail(user.getEmail(), key);
                return user;
            } catch (JsonProcessingException e) {
                throw new RedisException(e);
            }
        });
    }

    void saveByEmail(final String email, final String key) {
        run(jedis -> {
            jedis.set(name() + ':' + email, key);
            return null;
        });
    }

    public User findByEmail(final String email) {
        return (User) run(jedis -> {
            final String key = jedis.get(name() + ':' + email);
            if(key == null) {
                return null;
            }
            return findById(key);
        });
    }

    @Override
    public User findById(final String key)  {
        return (User) run(jedis -> {
            final String json = jedis.get(key);
            if(json == null) {
                log.warn("No user found for key {}", key);
                return null;
            }
            try {
                return fromJson(json, User.class);
            } catch (IOException e) {
                throw new RedisException(e);
            }
        });
    }

    public List<User> findAll() {
        return (List<User>) run(jedis -> jedis.smembers(name() + ":keys").stream().map((key) -> findById(key)).filter(Objects::nonNull).collect(Collectors.toList()));
    }

    private String name() {
        return User.class.getSimpleName().toLowerCase();
    }
}
