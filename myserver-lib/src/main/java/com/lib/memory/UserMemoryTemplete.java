package com.lib.memory;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

@Component("userMemoryTemplete")
public class UserMemoryTemplete extends Memory {

    private Cache<String, Object> cache;

    public static final Integer SUC = 1;

    public static final Integer FAIL = 0;

    private long maxSize = 1024;
    
    private long maxnum = 102400;
    
    private int exprieTime = 200;
    
    private TimeUnit timeutil = TimeUnit.MINUTES;
    
    private Date resetTime;
    
    private Date longgestRuningTime;
    
    private long higestSize;
    
    private UserMemoryTemplete() {
        if(cache == null) {
            synchronized (this) {
                if(cache == null) {
                    cache = CacheBuilder.newBuilder().maximumSize(maxSize).expireAfterWrite(exprieTime, timeutil)
                            .recordStats().build();
                    this.resetTime = new Date();
                    this.longgestRuningTime = new Date();
                }
            }
        }
    }

    @Override
    public int set(String key, Object value) throws Exception {
        try {
            cache.put(key, value);
        } catch (Exception e) {
            return FAIL;
        }
        return SUC;
    }

    @Override
    public void set(Map<? extends String, ? extends Object> map) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public Map<? extends String, ? extends Object> getm(Iterable<?> keys) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object get(String key) {
        return cache.getIfPresent(key);
    }

}
