package config;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@Configuration
public class CaffeineConfig {

    /**
     * 创建基于Caffeine的Cache Manager
     * @return
     */
    @Bean
    @Primary
    public CacheManager caffeineCacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        ArrayList<CaffeineCache> caches = new ArrayList<CaffeineCache>();
        caches.add(new CaffeineCache("foo",
                Caffeine.newBuilder().recordStats()
                        .expireAfterWrite(6000, TimeUnit.SECONDS)
                        .maximumSize(10000)
                        .build())
        );

        caches.add(new CaffeineCache("bar",
                Caffeine.newBuilder().recordStats()
                        .expireAfterWrite(3000, TimeUnit.SECONDS)
                        .maximumSize(10000)
                        .build())
        );
        cacheManager.setCaches(caches);
        return cacheManager;
    }
}
