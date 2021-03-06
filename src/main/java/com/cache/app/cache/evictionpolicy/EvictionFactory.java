package com.cache.app.cache.evictionpolicy;


import com.cache.app.cache.CacheConfiguration;
import com.cache.app.datastore.BaseDataStore;
import com.cache.app.enums.EvictionPolicy;

import java.util.HashMap;
import java.util.Map;

public class EvictionFactory {

    private static final Map<EvictionPolicy, BaseEvictionPolicy> DATA_STORES = new HashMap<>();

    public BaseEvictionPolicy createEvictionPolicy(EvictionPolicy evictionPolicy,
                                           CacheConfiguration configuration,
                                           BaseDataStore dataStore) {

        if(!DATA_STORES.containsKey(evictionPolicy)) {

            switch (evictionPolicy) {
                case LRU: {
                    DATA_STORES.put(evictionPolicy, new LRUEvictionPolicy(dataStore, configuration));
                } break;
            }

        }

        BaseEvictionPolicy store = DATA_STORES.get(evictionPolicy);

        if (store == null) {
            throw new RuntimeException("No such eviction policy " + evictionPolicy);
        }
        return store;
    }

}
