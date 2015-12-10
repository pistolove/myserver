package com.lib.transport;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

import com.lib.transport.user.request.UserRequest;

public class HttpClientTemplate {
	private static final Logger log = LoggerFactory.getLogger(HttpClientTemplate.class);
	
	@Resource
	private RestTemplate reTemplate;
	
	@Resource
	private AsyncRestTemplate asyncRestTemplate;
	
	public <T> T getForObject(UserRequest request, Class<T> responseType) throws Exception {
		long st = System.currentTimeMillis();
		String url = request.buildPath();
		try {
			T t = reTemplate.getForObject(url, responseType);
			long end = System.currentTimeMillis();
			log.info("excute: " + (end -st));
			return t;
		} catch (Exception e) {
			log.error("Exveption :" + (System.currentTimeMillis() - st));
			throw e;
		}
	}
	
	public <T> ListenableFuture<ResponseEntity<T>> getAsynForObject(UserRequest request, Class<T> responseType) throws Exception {
		long st = System.currentTimeMillis();
		String url = request.buildPath();
		try {
			ListenableFuture<ResponseEntity<T>> t = asyncRestTemplate.getForEntity(url, responseType);
			long end = System.currentTimeMillis();
			log.info("excute: " + (end -st));
			return t;
		} catch (Exception e) {
			log.error("Exveption :" + (System.currentTimeMillis() - st));
			throw e;
		}
	}
	
}
