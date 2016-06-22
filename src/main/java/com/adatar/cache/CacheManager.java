package com.adatar.cache;

public interface CacheManager {

    void init();

    void put(String key, Object value);

    Object get(String key);

    void remove(String key);

}
