package com.lib.memory;

import java.util.Map;

public abstract class Memory {

    public abstract int set(String key, Object value) throws Exception;
    
    public abstract void set(Map<? extends String, ? extends Object> map) throws Exception;
    
    public abstract Map<? extends String, ? extends Object> getm(Iterable<?> keys);
    
    public abstract Object get(String key);
    
    
}
