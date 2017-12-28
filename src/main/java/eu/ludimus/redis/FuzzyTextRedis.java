package eu.ludimus.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

@Component
class FuzzyTextRedis {
    @Autowired
    private DefaultRedisRunner defaultRedisRunner;
    private static final String[] VALUES = {
            "het", "een", "naar", "voor", "met", "wat", };
    private static final Set<String> IGNORE = new LinkedHashSet<>(Arrays.asList(VALUES));

    void save(final String key, final String text) {
        if(text == null) {
            return;
        }
        Arrays.stream(text.split("\\s+")).map(String::toLowerCase).forEach((word) -> saveWord(key, word));

    }

    Set<String> andSearch(final String... values) {
        final Set<String> common = new LinkedHashSet<>();
        return (Set<String>) defaultRedisRunner.run(jedis -> {
            Arrays.asList(values).forEach((word) -> {
                if(isValid(word)) {
                    if (common.isEmpty()) {
                        common.addAll(getMatch(jedis, word));
                    } else {
                        common.retainAll(getMatch(jedis, word));
                    }
                }
            });
            return common;
        });
    }

    Set<String> orSearch(final String... values) {
        final Set<String> all = new LinkedHashSet<>();
        return (Set<String>) defaultRedisRunner.run(jedis -> {
            Arrays.asList(values).forEach((word) -> {
                if(isValid(word)) {
                    all.addAll(getMatch(jedis, word));
                }
            });
            return all;
        });
    }

    private boolean isValid(final String word) {
        return !IGNORE.contains(word) && word.length() > 2 && !word.matches("\\d+");
    }

    private void saveWord(final String key, final String word) {
        if(!isValid(word)) {
            return;
        }
        defaultRedisRunner.run(jedis -> {
            final String wordKey = "word:" + word;
            jedis.sadd(wordKey, key);
            return null;
        });
    }


    private Set<String> getMatch(final Jedis jedis, final String value) {
        final String wordKey = "word:" + value.toLowerCase();
        return jedis.smembers(wordKey);
    }
}
