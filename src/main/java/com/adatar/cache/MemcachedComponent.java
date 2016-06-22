package com.adatar.cache;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.MemcachedClient;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MemcachedComponent implements CacheManager{

    @Value("${cacheTTL}")
    private int cacheTTL;

    @Value("${cacheEnabled}")
    private boolean cacheEnabled;

    @Value("${memcachedHosts}")
    private String memcachedHosts;

    private MemcachedClient memcachedClient;

    @PostConstruct
    public void init(){
        try{
            memcachedClient = new MemcachedClient(AddrUtil.getAddresses(memcachedHosts));
        }
        catch (IOException e){
            System.out.println("Could not connect to cache");
            cacheEnabled = false;
        }
    }

    public void put(String key, Object value){

        if(cacheEnabled && !StringUtils.isEmpty(key) && value != null){
            memcachedClient.add(key, cacheTTL, value);
        }
    }

    public String get(String key){

        String cacheValue = null;

        if(cacheEnabled) {
            Future<Object> future = memcachedClient.asyncGet(key);
            try {
                cacheValue = (String) future.get(1, TimeUnit.SECONDS);
            } catch (Exception e){
                future.cancel(true);
            }
        }

        return cacheValue;
    }

    public void remove(String key){

        if(cacheEnabled && !StringUtils.isEmpty(key))
            memcachedClient.delete(key);
    }

    @PreDestroy
    public void destroy(){
        memcachedClient.shutdown();
    }
}
