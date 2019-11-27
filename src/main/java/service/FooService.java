package service;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.caffeine.CaffeineCacheManager;

import java.util.Collection;

@org.springframework.stereotype.Service
public class FooService {
    @Autowired
    private CaffeineCacheManager caffeineCacheManager;

    @Cacheable(cacheNames = {"foo"},key = "#fooname")
    public String foo(String fooname){
        String result = "get from db...";
        System.out.println(result);
        return fooname;
    }
    public String getCache(String cachenane,String key){
        Collection<String> collect = caffeineCacheManager.getCacheNames();
        CaffeineCache cache = (CaffeineCache)caffeineCacheManager.getCache(cachenane);
        Cache.ValueWrapper cv = cache.get(key);
        Object o = cv.get();


        return "";
    }
}
