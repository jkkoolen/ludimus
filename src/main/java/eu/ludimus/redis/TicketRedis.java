package eu.ludimus.redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import eu.ludimus.model.Ticket;
import eu.ludimus.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Component
public class TicketRedis extends AbstractRedis<Ticket> {
    @Autowired
    private FuzzyTextRedis fuzzyTextRedis;

    @Override
    public Ticket save(final Ticket ticket) {
        return (Ticket) run(jedis -> {
            ticket.setId(getId(Ticket.class, ticket.getId()));
            final String key = name(Ticket.class) + ':' + ticket.getId() + ":" + name(User.class) + ":" + ticket.getUser().getId();
            jedis.sadd(name(Ticket.class) + ":keys:" + name(User.class) + ":" + ticket.getUser().getId(), key);
            try {
                User user = ticket.getUser();
                ticket.setUser(null); //because there is no use to store the user in the ticket
                fuzzyTextRedis.save(key, ticket.getDescription());
                final String value = toJson(ticket);
                jedis.set(key, value);
                saveByUserAndTicketDate(user, ticket.getTicketDate(), key);
                return ticket;
            } catch (JsonProcessingException e) {
                throw new RedisException(e);
            }
        });
    }

    public List<Ticket> orSearchByUser(final User user, final String... values) {
        final String userKey = "user:" + user.getId();
        return fuzzyTextRedis.orSearch(values).stream().filter((key) -> key.indexOf(userKey) > -1).map((key) -> findById(key)).collect(Collectors.toList());
    }

    public List<Ticket> andSearchByUser(final User user, final String... values) {
        final String userKey = "user:" + user.getId();
        return fuzzyTextRedis.andSearch(values).stream().filter((key) -> key.indexOf(userKey) > -1).map((key) -> findById(key)).collect(Collectors.toList());
    }

    void saveByUserAndTicketDate(final User user, final Date ticketDate, final String key) {
        run(jedis -> {
            final String userTicketDateKey = User.class.getSimpleName().toLowerCase() + ':' + user.getId() + ":ticketdate";
            jedis.zadd(userTicketDateKey, ticketDate.getTime(), key);
            return null;
        });
    }

    public List<Ticket> findByUserAndTicketDateBetween(final User user, final Date from , final Date to) {
        return (List<Ticket>) run(jedis -> {
            final String userTicketDateKey = User.class.getSimpleName().toLowerCase() + ':' + user.getId() + ":ticketdate";
            final Set<String> keys = jedis.zrangeByScore(userTicketDateKey, from.getTime(), to.getTime());
            return keys.stream().map((key) -> findById(key)).collect(Collectors.toList());
        });
    }

    @Override
    public Ticket findById(final String key)  {
        return (Ticket) run(jedis -> {
            try {
                final String json = jedis.get(key);
                if(json == null) {
                    log.warn("No ticket found for key {}", key);
                    return null;
                }
                return fromJson(json, Ticket.class);
            } catch (IOException e) {
                throw new RedisException(e);
            }
        });
    }

    public List<Ticket> findAllByUser(final User user) {
        return (List<Ticket>) run(jedis -> {
            final String key = name(Ticket.class) + ":keys:" + name(User.class) + ":" + user.getId();
            final List<Ticket> list = jedis.smembers(key).stream().map((k) -> findById(k)).collect(Collectors.toList());
            return list;
        });
    }
}
