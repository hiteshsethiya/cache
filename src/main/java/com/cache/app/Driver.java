package com.cache.app;

import com.cache.app.cache.RCache;
import com.cache.app.cache.CacheConfiguration;
import com.cache.app.enums.DataStore;
import com.cache.app.enums.EvictionPolicy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Driver {

    public static void main(String[] args) {

        CacheConfiguration cacheConfiguration = new CacheConfiguration(
                EvictionPolicy.LRU,
                DataStore.MEMORY_MAP,
                10
        );
        
        RCache rCache = new RCache(cacheConfiguration);

        rCache.put("key1", "value1");
        rCache.put("key2", "value2");
        rCache.put("key3", "value3");
        rCache.put("key4", "value4");
        rCache.put("key5", "value5");
        rCache.put("key6", "value6");
        rCache.put("key7", "value7");
        rCache.put("key8", "value8");
        rCache.put("key9", "value9");
        rCache.put("key10", "value10");

        log.info("" + rCache.get("key10"));
        log.info("" + rCache.isFull());

        rCache.put("key11", "value11");
        rCache.remove("key1");
        rCache.remove("key123");

        log.info("" + rCache.get("key123"));

        log.info("Completed");
    }

}
