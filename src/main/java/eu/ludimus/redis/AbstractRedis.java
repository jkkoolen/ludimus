package eu.ludimus.redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public abstract class AbstractRedis<T> extends DefaultRedisRunner implements Redis<T> {
    private ObjectMapper mapper = new ObjectMapper();

    public String toJson(final T object) throws JsonProcessingException {
        return mapper.writeValueAsString(object);
    }

    public T fromJson(final String json, Class<T> clazz) throws IOException {
        return mapper.readValue(json, clazz);
    }

    @Override
     public Long getId(final Class<?> clazz, Long currentId) {
        return (Long) run(jedis -> {
            final String key = name(clazz) + ":index";
            if(currentId != null) {
                final String currentStored = jedis.get(key);
                Long storedId = currentStored != null ? Long.valueOf(currentStored) : 0L;
                jedis.set(key, String.valueOf(Math.max(currentId, storedId)));
                return currentId;
            }

            return jedis.incr(key);
        });
    }

    @Override
    public String name(final Class<?> clazz) {
        return clazz.getSimpleName().toLowerCase();
    }
 }
