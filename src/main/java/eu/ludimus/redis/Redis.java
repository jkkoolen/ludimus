package eu.ludimus.redis;

public interface Redis<T> extends RedisRunner{
    T save(T object) throws RedisException;
    T findById(final String key) throws RedisException;
    Long getId(Class<?> clazz, Long currentId);
    String name(Class<?> clazz);
}
