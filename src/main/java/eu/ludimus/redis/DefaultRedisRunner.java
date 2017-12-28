package eu.ludimus.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
public class DefaultRedisRunner implements RedisRunner {
    @Autowired
    private JedisPool jedisPool;

    public Object run(final Runner runner) {
        final Jedis resource = jedisPool.getResource();
        final Object result = runner.run(resource);
        resource.close();
        return result;
    }

}
