package com.timer.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lib.server.CacheTemplate;
import com.lib.server.memcache.MemcacheTemplate;
import com.lib.server.rmi.RmiInterface;

@Service
public class RmiServer extends UnicastRemoteObject implements RmiInterface {
	private static final long serialVersionUID = -1808687292095223102L;

	private static final Logger log = LoggerFactory.getLogger(RmiServer.class);
	
	@Resource
	private static CacheTemplate memcached;
	
	static {
	    memcached = new MemcacheTemplate();
	}

	public CacheTemplate getMemcached() {
		return memcached;
	}

	public void setMemcached(CacheTemplate memcached) {
		this.memcached = memcached;
	}

	public RmiServer() throws RemoteException {
		super();
	}

	public Object get(String key) {
		return memcached.get(key);
	}

	public void delete(String key) {
		memcached.delete(key);
	}

	public int set(String key, Object obj) {
		return memcached.set(key, obj);
	}

//	public int update(String key, Object value, int ... time) {
//		int result = 0;
//		if(time != null && time.length > 0) {
//			result = memcached.set(key, value, time[0]);
//		} else {
//			result = memcached.set(key, value);
//		}
//		if(result == 1) {
//			log.error("update error");
//		}
//		
//		return result;
//	}

}
