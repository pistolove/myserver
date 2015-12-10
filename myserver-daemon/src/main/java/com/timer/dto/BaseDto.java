package com.timer.dto;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

public class BaseDto implements Serializable {
    private static final long serialVersionUID = -9034586269858454497L;

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
