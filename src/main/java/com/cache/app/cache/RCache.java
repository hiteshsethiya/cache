package com.cache.app.cache;

import com.cache.app.cache.evictionpolicy.BaseEvictionPolicy;
import com.cache.app.cache.evictionpolicy.EvictionFactory;
import com.cache.app.datastore.BaseDataStore;
import com.cache.app.datastore.DataStoreFactory;

public class RCache {

    private Cache cache;
    private DataStoreFactory dataStoreFactory;
    private EvictionFactory evictionFactory;

    public RCache(CacheConfiguration cacheConfiguration) {

        this.dataStoreFactory = new DataStoreFactory();
        this.evictionFactory = new EvictionFactory();

        BaseDataStore dataStore = dataStoreFactory.getDataStore(cacheConfiguration.getDataStore());
        BaseEvictionPolicy evictionPolicy = evictionFactory.createEvictionPolicy(
                cacheConfiguration.getEvictionPolicy(), cacheConfiguration, dataStore
        );

        cache = new Cache(cacheConfiguration,
                dataStore,
                evictionPolicy);
    }


    public boolean isFull() {
        return cache.isFull();
    }

    public void put(String key, Object value) {
        cache.put(key, value);
    }

    public Object get(String key) {
        return cache.get(key);
    }

    public void remove(String key) {
        cache.remove(key);
    }
}