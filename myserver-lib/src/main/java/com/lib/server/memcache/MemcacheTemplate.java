package com.lib.server.memcache;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.code.yanf4j.core.impl.StandardSocketOption;
import com.lib.server.CacheTemplate;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.rubyeye.xmemcached.utils.AddrUtil;

@Component("cacheTemplate")
public class MemcacheTemplate extends CacheTemplate {

	protected MemcachedClientBuilder builder = new XMemcachedClientBuilder(
			AddrUtil.getAddresses("127.0.0.1:11211"));

	private static final Logger log = LoggerFactory.getLogger(MemcacheTemplate.class);
	
	protected MemcachedClient client;

	public MemcacheTemplate() {

		builder.setSocketOption(StandardSocketOption.SO_RCVBUF, 12 * 1024);
		builder.setSocketOption(StandardSocketOption.SO_SNDBUF, 6 * 1024);
		builder.setConnectionPoolSize(2);
		builder.getConfiguration().setStatisticsServer(false);

		try {
			client = builder.build();
			client.setOptimizeMergeBuffer(false);
			client.setEnableHeartBeat(false);
			client.setOpTimeout(3000);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String get(String key) {
		if (key != null) {
			try {
				return client.get(key);
			} catch (TimeoutException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (MemcachedException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public void delete(String key) {
		if (key != null) {
			try {
				client.delete(key);
			} catch (TimeoutException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (MemcachedException e) {
				e.printStackTrace();
			}
		}
	}

	public int set(String key, Object obj) {
		if (key != null) {
			try {
				client.set(key, 0, obj);
				return 0;
			} catch (Exception e) {
				e.printStackTrace();
				return 1;
			} 
		}
		return 1;
	}

	@Override
	public int set(String key, Object obj, int timeout) {
		if(obj == null) {
			return 0;
		}
		
		try {
			client.set(key, timeout, obj);
		} catch (Exception e) {
			log.error("set key and value eroor");
			return 1;
		}
		return 0;
	}

}
