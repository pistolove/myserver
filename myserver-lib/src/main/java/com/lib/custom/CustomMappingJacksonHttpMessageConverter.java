package com.lib.custom;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

public class CustomMappingJacksonHttpMessageConverter extends MappingJackson2HttpMessageConverter {

    public CustomMappingJacksonHttpMessageConverter() {
        List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();

        supportedMediaTypes.addAll(this.getSupportedMediaTypes());
        supportedMediaTypes.add(new MediaType("text", "html", DEFAULT_CHARSET));

        this.setSupportedMediaTypes(supportedMediaTypes);
    }
}
