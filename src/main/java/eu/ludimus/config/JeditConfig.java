package eu.ludimus.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Protocol;

import java.net.URI;
import java.net.URISyntaxException;

@Configuration
public class JeditConfig {
    @Value("${jedis.pool.host}")
    private String jedisHost;

    @Bean
    public JedisPool getJedisPool() {
        try {
            URI jedisURI = new URI(jedisHost);
            return new JedisPool(new JedisPoolConfig(), jedisURI.getHost(),
                    jedisURI.getPort(), Protocol.DEFAULT_TIMEOUT, null);
        } catch (URISyntaxException e) {
            throw new RuntimeException(
                    "Redis couldn't be configured :" + jedisHost);
        }
    }
}
