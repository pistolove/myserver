package com.lib.server;

public abstract class CacheTemplate {
	
	public abstract String get(String key);

	public abstract void delete(String key);

	public abstract int set(String key, Object obj);
	
	public abstract int set(String key, Object obj, int timeout);
}
