package eu.ludimus.redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import eu.ludimus.model.Kmr;
import eu.ludimus.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Component
public class KmrRedis extends AbstractRedis<Kmr> {
    @Override
    public Kmr save(final Kmr kmr) {
        return (Kmr) run(jedis -> {
            boolean isNew = kmr.getId() == null;
            if(isNew) {
                kmr.preUpdate();
            } else {
                kmr.prePersist();
            }
            kmr.setId(getId(Kmr.class, kmr.getId()));

            final String key = name(Kmr.class) + ':' + kmr.getId() + ":" + name(User.class) + ":" + kmr.getUser().getId();

            final User user = kmr.getUser();
            if(isNew) {
                final String lastKmrIdKey = name(User.class) + ':' + user.getId() + ":lastkmrid";
                jedis.set(lastKmrIdKey, key);
            }
            jedis.sadd(name(Kmr.class) + ":keys:" + name(User.class) + ":" + kmr.getUser().getId(), key);
            try {
                kmr.setUser(null); //because there is no use to store the user in the ticket
                final String value = toJson(kmr);
                jedis.set(key, value);
                saveByUserAndKmrDay(user, kmr.getDay(), key);
                return kmr;
            } catch (JsonProcessingException e) {
                throw new RedisException(e);
            }
        });
    }

    void saveByUserAndKmrDay(final User user, final Date ticketDate, final String key) {
        run(jedis -> {
            final String userKmrDayKey = User.class.getSimpleName().toLowerCase() + ':' + user.getId() + ":kmrDay";
            jedis.zadd(userKmrDayKey, ticketDate.getTime(), key);
            return null;
        });
    }

    public List<Kmr> findByUserAndDayBetween(final User user, final Date from , final Date to) {
        return (List<Kmr>) run(jedis -> {
            final String userKmrDateKey = User.class.getSimpleName().toLowerCase() + ':' + user.getId() + ":kmrDay";
            final Set<String> keys = jedis.zrangeByScore(userKmrDateKey, from.getTime(), to.getTime());
            return keys.stream().map((key) -> findById(key)).filter(Objects::nonNull).collect(Collectors.toList());
        });
    }

    public Kmr findLastKmrByUser(final User user) {
        return (Kmr) run(jedis -> {
            final String lastKmrIdKey = User.class.getSimpleName().toLowerCase() + ':' + user.getId() + ":lastkmrid";
            final String kmrIdKey = jedis.get(lastKmrIdKey);
            if(kmrIdKey == null) {
                return null;
            }
            return findById(kmrIdKey);
        });
    }

    @Override
    public Kmr findById(final String key)  {
        return (Kmr) run(jedis -> {
            try {
                final String json = jedis.get(key);
                if(json == null) {
                    log.warn("No ticket found for key {}", key);
                    return null;
                }
                return fromJson(json, Kmr.class);
            } catch (IOException e) {
                throw new RedisException(e);
            }
        });
    }

    public List<Kmr> findAllByUser(final User user) {
        return (List<Kmr>) run(jedis -> {
            final String key = name(Kmr.class) + ":keys:" + name(User.class) + ":" + user.getId();
            final List<Kmr> list = jedis.smembers(key).stream().map((k) -> findById(k)).collect(Collectors.toList());
            return list;
        });
    }
}
