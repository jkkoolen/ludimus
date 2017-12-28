package eu.ludimus.redis;

import redis.clients.jedis.Jedis;

public interface RedisRunner {
    Object run(final Runner runner);

    interface Runner {
        Object run(final Jedis jedis) throws RedisException;
    }
}
