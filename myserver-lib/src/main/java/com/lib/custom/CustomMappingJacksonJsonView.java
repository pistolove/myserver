package com.lib.custom;


import java.util.Map;

import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * BUG:MappingJacksonJsonView返回 {model类名:{内容}}
 */
public class CustomMappingJacksonJsonView extends MappingJackson2JsonView {

    @Override
    protected Object filterModel(Map<String, Object> model) {
        Map<?, ?> result = (Map<?, ?>) super.filterModel(model);
        for (Object object : result.values()) {
            if (!"xserver.api.module.CommonParam".equals(object.getClass().getName())) {
                return object;
            }
        }
        return result.values().iterator().next();
    }
}
