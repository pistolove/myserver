package myserver.api.modules.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

public class BaseDto implements Serializable{
	private static final long serialVersionUID = 5514875519547969649L;

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
		
	}
}
