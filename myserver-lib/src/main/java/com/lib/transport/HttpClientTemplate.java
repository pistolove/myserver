package com.lib.transport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

import com.lib.transport.user.request.UserRequest;

@Component
public class HttpClientTemplate {
	private static final Logger log = LoggerFactory.getLogger(HttpClientTemplate.class);
	
	private RestTemplate reTemplate = new RestTemplate();
	
	private AsyncRestTemplate asyncRestTemplate = new AsyncRestTemplate();
	
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
