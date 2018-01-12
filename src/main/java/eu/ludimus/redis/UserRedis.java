package eu.ludimus.redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import eu.ludimus.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class UserRedis extends AbstractRedis<User> {
    @Override
    public User save(final User user) {
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
                saveByEmailAndPassword(user.getEmail(), user.getPassword(), key);
                return user;
            } catch (JsonProcessingException e) {
                throw new RedisException(e);
            }
        });
    }

    void saveByEmailAndPassword(final String email, final String password, final String key) {
        run(jedis -> {
            jedis.set(name() + ':' + email + password, key);
            return null;
        });
    }

    public User findByEmailAndPassword(final String email, final String password) {
        return (User) run(jedis -> {
            final String key = jedis.get(name() + ':' + email + password);
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
        return (List<User>) run(jedis -> {
            return jedis.smembers(name() + ":keys").stream().map((key) -> findById(key)).collect(Collectors.toList());
        });
    }

    private String name() {
        return User.class.getSimpleName().toLowerCase();
    }
}
