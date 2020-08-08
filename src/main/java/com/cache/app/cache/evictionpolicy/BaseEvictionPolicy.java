package com.cache.app.cache.evictionpolicy;

import com.cache.app.cache.CacheConfiguration;
import com.cache.app.datastore.BaseDataStore;
import lombok.Getter;


@Getter
public abstract class BaseEvictionPolicy {

    private BaseDataStore baseDataStore;

    private CacheConfiguration cacheConfiguration;

    public BaseEvictionPolicy(BaseDataStore baseDataStore, CacheConfiguration cacheConfiguration) {
        this.baseDataStore = baseDataStore;
        this.cacheConfiguration = cacheConfiguration;
    }

    public abstract void evict();

    public abstract void onPut(String key, Object value);

    public abstract void onRead(String key);

    public abstract void onRemove(String key);
}
