package com.lib.transport;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.stereotype.Component;
import com.lib.server.CacheTemplate;

@Component
public class BaseTpDao {

	@Resource
	protected HttpClientTemplate httpClientTemplate;
	
	@Resource 
	protected CacheTemplate cacheTemplate;
	
	protected static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	{
	     OBJECT_MAPPER.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	     OBJECT_MAPPER.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
	     OBJECT_MAPPER.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
	     OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
	}
	
}
