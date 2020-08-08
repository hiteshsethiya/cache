package com.cache.app.cache;

import com.cache.app.enums.DataStore;
import com.cache.app.enums.EvictionPolicy;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class CacheConfiguration {
    private EvictionPolicy evictionPolicy;
    private DataStore dataStore;
    private int cacheSize;
}
